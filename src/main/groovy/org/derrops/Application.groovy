package org.derrops

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.servlet.HandlerAdapter
import org.springframework.web.servlet.HandlerMapping
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
class Application {

    // silence console logging
    @Value('${logging.level.root:OFF}')
    String message = ""

    /*
     * Create required HandlerMapping, to avoid several default HandlerMapping instances being created
     */
    @Bean
    HandlerMapping handlerMapping() {
        return new RequestMappingHandlerMapping()
    }

    /*
     * Create required HandlerAdapter, to avoid several default HandlerAdapter instances being created
     */
    @Bean
    HandlerAdapter handlerAdapter() {
        return new RequestMappingHandlerAdapter()
    }

    static void main(String[] args) {
        SpringApplication.run(Application.class, args)
    }
}