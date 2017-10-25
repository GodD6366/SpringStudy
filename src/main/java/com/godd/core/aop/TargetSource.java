package com.godd.core.aop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 * User: godd
 * Date: 2017-10-25
 * Time: 下午8:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TargetSource {

    private Object target;
    private Class targetClass;
}
