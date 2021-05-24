package com.demo.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ppmsn2005@gmail.com
 * @date 2020/7/24
 */
@Data
@NoArgsConstructor
public class CommonResult<T> {
    private Long code;
    private String message;
    private T data;

    public CommonResult(Long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
