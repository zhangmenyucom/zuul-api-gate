package com.taylor.errorattributes;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/30 10:44
 */
public class ZuulErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String,Object> result=super.getErrorAttributes(requestAttributes,includeStackTrace);
        result.remove("exception");
        result.put("test","you are a shabi");
        result.put("var","1231321");
        return result;
    }
}
