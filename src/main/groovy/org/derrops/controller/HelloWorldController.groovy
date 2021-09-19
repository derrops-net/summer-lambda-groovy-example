package org.derrops.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @RequestMapping("/hello")
    public String index() {
        return "Hell what is happening!.";
    }

}
