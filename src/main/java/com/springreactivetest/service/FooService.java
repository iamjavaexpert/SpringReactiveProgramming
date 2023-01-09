package com.springreactivetest.service;

import com.springreactivetest.entity.Foo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
@Service
public class FooService {

    //Initialise the foo
    private List<Foo> fooList = List.of(new Foo(1l, "foo1"),new Foo(2l, "foo2"), new Foo(3l, "foo3"), new Foo(4l, "foo4"), new Foo(5l, "foo5"),new Foo(6l, "foo6"),new Foo(7l, "foo7"),new Foo(8l, "foo8"),new Foo(9l, "foo9"),new Foo(10l, "foo10"),new Foo(11l, "foo11"),new Foo(12l, "foo12"));
    public Flux<Foo> getFooInfo() {
        return Flux
                .fromIterable(fooList)
                .delayElements(Duration.ofSeconds(1))
                .log();
    }
}
