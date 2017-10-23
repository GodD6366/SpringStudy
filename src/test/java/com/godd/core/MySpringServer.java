package com.godd.core;

import lombok.Data;

import java.util.Date;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午9:26
 */
@Data
public class MySpringServer {

    private String name;

    private Date createTime;

    public void sayHello() {
        System.out.println(createTime + ": hello mySpringServer from " + name);
    }
}
