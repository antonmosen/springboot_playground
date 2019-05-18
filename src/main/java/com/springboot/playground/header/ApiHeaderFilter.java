package com.springboot.playground.header;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
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
@Getter
@Setter
//@PropertySource("classpath:application.properties")
//@EncryptablePropertySource("application.properties")
//@EnableEncryptableProperties
public class ApiHeaderFilter extends GenericFilterBean {

    @Value("${header.parameter.app.x.trace}")
    private String headerParameterAppXTrace;
    @Value("${header.parameter.app.x.value}")
    private String headerParameterAppValue;

    @Value("${app.x.trace}")
    private String appXTrace;
    @Value("${app.x.value}")
    private String appXValue;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (isNotValidCredentials(request.getHeader(headerParameterAppXTrace), appXTrace)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No valid header parameter : " + headerParameterAppXTrace);
            return;
        }

        if (isNotValidCredentials(request.getHeader(headerParameterAppValue), appXValue)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No valid header parameter : " + headerParameterAppValue);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isNotValidCredentials(String headerValue, String appValue) {

        if (headerValue == null || appValue == null) {
            return true;
        }
        if ("".equals(headerValue) || "".equals(appValue)) {
            return true;
        }
        return !headerValue.equals(appValue);
    }
}









