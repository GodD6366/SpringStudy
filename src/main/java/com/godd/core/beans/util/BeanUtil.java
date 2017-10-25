package com.godd.core.beans.util;

/**
 * Description:
 * User: godd
 * Date: 2017-10-24
 * Time: 上午11:07
 */
public class BeanUtil {
    /**
     * 生成getter名
     *
     * @author 戴长春    dcc@vtc365.com
     * @date 2017/10/25 上午11:04
     */
    public static String parseSetter(String name){
        return "set"+name.substring(0,1).toUpperCase()+name.substring(1);
    }
}
