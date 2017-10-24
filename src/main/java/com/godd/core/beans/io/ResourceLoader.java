package com.godd.core.beans.io;

import java.net.URL;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午10:37
 */
public class ResourceLoader {
    public Resource getResource(String location){
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
