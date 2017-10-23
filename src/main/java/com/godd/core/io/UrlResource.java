package com.godd.core.io;

import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午10:45
 */
@Data
public class UrlResource implements Resource{
    private URL resource;
    public UrlResource(URL resource) {
        this.resource = resource;
    }

    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = resource.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
