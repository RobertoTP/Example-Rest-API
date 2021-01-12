package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.concurrent.atomic.AtomicInteger;

@ApiModel(value = "World", description = "World Object")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class World {

    private static final AtomicInteger count = new AtomicInteger(0);

    @ApiModelProperty(name = "message", value = "message", example = "Hello World", required = true)
    private String message;

    @ApiModelProperty(name = "id", value = "number", example = "1", required = true)
    private Integer id;

    public String getMessage() {
        this.message = "Hello World";
        return this.message;
    }

    public Integer getId() {
        this.id = count.incrementAndGet();
        return this.id;
    }
}
