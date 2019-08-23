package com.example.springboot.demo.errorpage;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Created by jianglei on 2019/5/17.
 */
@Component
public class RegisterErrorPage implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.html");
        ErrorPage error403Page = new ErrorPage(HttpStatus.FORBIDDEN, "/error/403.html");
        ErrorPage error405Page = new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED, "/error/405.html");
        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500.html");
        registry.addErrorPages(error404Page, error403Page, error405Page, error500Page);
    }
}
