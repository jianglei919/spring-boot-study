package com.example.spring.study.designpatterns.chaintemplate.search;

import com.example.spring.study.designpatterns.chaintemplate.base.Handler;
import com.example.spring.study.designpatterns.chaintemplate.base.HandlerChain;
import com.example.spring.study.designpatterns.chaintemplate.base.HandlerFactory;
import com.example.spring.study.designpatterns.chaintemplate.enums.HandlerType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jianglei on 2019/9/20.
 */
@Slf4j
@Service("searchHandlerFactory")
public class SearchHandlerFactory extends HandlerFactory {

    private HandlerChain invokerHandlerChain;

    @Resource
    private List<Handler> invokerHandlerList;

    @PostConstruct
    private void init() {
        try {
            int handlerSize = invokerHandlerList.size();
            invokerHandlerList = invokerHandlerList.stream()
                    .filter(filter -> filter.valid())
                    .filter(filter -> filter.getType().type == HandlerType.SEARCH.type)
                    .sorted(Comparator.comparingInt(filter -> filter.getHandlerOrder().order))
                    .collect(Collectors.toList());
            invokerHandlerChain = createInvokerHandlerChain(invokerHandlerList);
            log.info("init InvokerHandler success, old size:{}, new size:{}", handlerSize, invokerHandlerList.size());
        } catch (Exception e) {
            throw new RuntimeException("init InvokeHandler fail");
        }
    }

    @Override
    public HandlerChain selectInvokerHandlerChain() {
        return invokerHandlerChain;
    }
}
