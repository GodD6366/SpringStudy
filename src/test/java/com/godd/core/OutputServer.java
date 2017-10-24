package com.godd.core;

import lombok.Data;

/**
 * Description:
 * User: godd
 * Date: 2017-10-24
 * Time: 下午9:30
 */
@Data
public class OutputServer {
    private MySpringServer mySpringServer;

    private String name;

    public void sayHello(){
        System.out.println("hello daichangchun");
        mySpringServer.sayHello();
    }
}
