package com.godd.core.aop;

import com.godd.core.OutputServer;
import lombok.Data;

/**
 * Description:
 * User: godd
 * Date: 2017-10-25
 * Time: 下午8:36
 */
@Data
public class HelloWorldServiceImpl implements HelloWorldService{

    private String text;

    private OutputServer outputService;

    @Override
    public void helloWorld() {
        outputService.sayHello();
    }
}
