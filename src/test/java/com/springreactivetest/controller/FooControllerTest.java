package com.springreactivetest.controller;

import com.springreactivetest.service.FooService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;
import com.springreactivetest.entity.Foo;

@WebFluxTest(FooController.class)
@AutoConfigureWebTestClient(timeout = "50000")
@Import(FooService.class)
public class FooControllerTest {

    @MockBean
    FooService service;
    @Autowired
    private WebTestClient webTestClient;
    @Test
    void testFlux() {

        webTestClient.get().uri("/foo").exchange().expectStatus()
                .isOk().expectBodyList(Foo.class);
    }

}
