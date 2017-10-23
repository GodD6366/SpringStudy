package com.godd.core;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午10:16
 */
public class PropertyValues {
    private Set<PropertyValue> propertyValueList = new HashSet<PropertyValue>();

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValueList.add(propertyValue);
    }

    public Set<PropertyValue> getPropertyValues() {
        return this.propertyValueList;
    }
}
