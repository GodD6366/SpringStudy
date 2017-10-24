package com.godd.core.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午10:44
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
