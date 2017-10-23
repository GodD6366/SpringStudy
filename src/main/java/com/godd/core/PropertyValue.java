package com.godd.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午10:00
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class PropertyValue {
    private String name;
    private Object value;
}
