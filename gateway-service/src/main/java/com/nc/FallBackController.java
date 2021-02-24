package com.nc;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

    @HystrixCommand
    @GetMapping("/categoryFallBack")
    public Mono<String> categoryServiceFallBack(){
        return Mono.just("CATEGORY-SERVICE is taking too long time to response or it's DOWN");
    }

    @HystrixCommand
    @GetMapping("/productFallBack")
    public Mono<String> productServiceFallBack(){
        return Mono.just("PRODUCT-SERVICE is taking too long time to response or it's DOWN");
    }
}
