package com.godd.core.Property;

import com.godd.core.Property.PropertyValue;

import java.util.HashSet;
import java.util.Iterator;
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

        //stream版本实现
//        propertyValueList.stream()
//                .filter(item -> item.getName().equals(propertyValue.getName()))
//                .forEach(property -> {
//                    System.out.println("[发现重复项] " + property.getName() + "执行覆盖");
//                    property.setValue(propertyValue.getValue());
//                });

        boolean isOverride = false;
        Iterator<PropertyValue> iterator = propertyValueList.iterator();
        while (iterator.hasNext()) {
            PropertyValue property = iterator.next();
            if (property.getName().equals(propertyValue.getName())) {
//                System.out.println("[发现重复项] '" + property.getName() + "' 执行覆盖");
                property.setValue(propertyValue.getValue());
                isOverride = true;
                break;
            }
        }

        if (!isOverride){
//            System.out.println("[未发现重复项] 执行添加");
            this.propertyValueList.add(propertyValue);
        }
    }

    public Set<PropertyValue> getPropertyValues() {
        return this.propertyValueList;
    }
}
