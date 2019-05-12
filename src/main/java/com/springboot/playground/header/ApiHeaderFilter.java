package com.springboot.playground.header;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class ApiHeaderFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String FIRST_NAME = "firstname";
        String LAST_NAME = "lastname";

        if (isNullOrEmpty(request.getHeader(FIRST_NAME))) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No valid header parameter : "+ FIRST_NAME);
            return;
        }

        if (isNullOrEmpty(request.getHeader(LAST_NAME))) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No valid header parameter : "+ LAST_NAME);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isNullOrEmpty(String value) {
        if (value == null) {
            return true;
        }
        return "".equals(value);
    }
}
