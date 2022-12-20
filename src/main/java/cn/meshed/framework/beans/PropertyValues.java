package cn.meshed.framework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>bean 注入属性列表</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();



    public void addPropertyValue(PropertyValue propertyValue) {
        if (propertyValue != null){
            this.propertyValueList.add(propertyValue);
        }
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : this.propertyValueList) {
            if (propertyValue.getName().equals(propertyName)){
                return propertyValue;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "PropertyValues{" +
                "propertyValueList=" + propertyValueList +
                '}';
    }
}
