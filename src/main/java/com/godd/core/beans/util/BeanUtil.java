package com.godd.core.beans.util;

/**
 * Description:
 * User: godd
 * Date: 2017-10-24
 * Time: 上午11:07
 */
public class BeanUtil {
    public static String parseSetter(String name){
        return "set"+name.substring(0,1).toUpperCase()+name.substring(1);
    }
}
