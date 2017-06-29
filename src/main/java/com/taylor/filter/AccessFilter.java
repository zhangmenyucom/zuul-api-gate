package com.taylor.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/29 16:38
 */
@Slf4j
@Component
@Configuration
public class AccessFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        try {
            log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
            Object accessToken = request.getParameter("accessToken");
            if (accessToken == null) {
                log.warn("acess tokeen is empty");
                ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                ctx.set("error.message","acess token is empty");
                return null;
            }
            log.info("access is ok");
        } catch (Exception e) {
            ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            ctx.set("error.exception", e);
            e.printStackTrace();
        }
        return null;
    }
}
