package com.taylor.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/30 9:46
 */
@Component
public class ErrorExtFilter extends SendErrorFilter {

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 30;//大于errorFilter的值
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ZuulFilter filter = (ZuulFilter) ctx.get("faild.filter");
        if (filter != null && "post".equals(filter.filterType())) {
            return true;
        }
        return false;
    }
}
