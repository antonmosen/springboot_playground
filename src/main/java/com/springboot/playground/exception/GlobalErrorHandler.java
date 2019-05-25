package com.springboot.playground.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


/*
* Global errorhandler that is used when
* exception is thrown outside controllers, maybe in Filter(s)
* or whatever.
* handleError() only maps that error and rethrow it to CustomerResponseEntityErrorMapper
* so all exceptions is created in same place.
*
* */
@Controller
public class GlobalErrorHandler implements ErrorController {

    @RequestMapping("/error")
    public void handleError(HttpServletRequest request) throws Throwable {
        String exception = "javax.servlet.error.exception";
        if (request.getAttribute(exception) != null) {
            throw (Throwable) request.getAttribute(exception);
        }
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
