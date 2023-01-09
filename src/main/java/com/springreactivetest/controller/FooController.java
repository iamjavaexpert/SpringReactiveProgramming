package com.springreactivetest.controller;

import com.springreactivetest.entity.Foo;
import com.springreactivetest.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class FooController {

    @Autowired
    private FooService fooService;
    @GetMapping(path = "/foo",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Foo> getFoo(){
        return fooService.getFooInfo();
    }
}
