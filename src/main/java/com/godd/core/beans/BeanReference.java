package com.godd.core.beans;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Description:
 * User: godd
 * Date: 2017-10-24
 * Time: 下午9:42
 */
@Data
@Accessors(chain = true)
public class BeanReference {
    private String name;
//    private String reference;

    public BeanReference(String name) {
        this.name = name;
    }
}
