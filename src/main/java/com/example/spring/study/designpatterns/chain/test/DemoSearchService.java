package com.example.spring.study.designpatterns.chain.test;

import com.example.spring.study.designpatterns.chain.base.HandlerChain;
import com.example.spring.study.designpatterns.chain.base.HandlerFactory;
import com.example.spring.study.designpatterns.chain.search.SearchInvocationContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jianglei on 2019/10/15.
 */
@Slf4j
@Service
public class DemoSearchService {

    @Resource(name = "searchHandlerFactory")
    private HandlerFactory searchHandlerFactory;

    public void search() {
        SearchInvocationContext searchInvocationContext = new SearchInvocationContext();
        HandlerChain handlerChain = searchHandlerFactory.selectInvokerHandlerChain();
        handlerChain.doChain(searchInvocationContext);
    }
}
