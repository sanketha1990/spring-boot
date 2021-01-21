package com.distrubuted.keyvalue.util;

import com.distrubuted.keyvalue.dto.ValueObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataTypeFactory {

    public static String getDataType(Object obj){
        if(obj instanceof String){
            return "java.lang.String";
        }
        if(obj instanceof Double){
            return "java.lang.Double";
        }
        if(obj instanceof Integer){
            return "java.lang.Integer";
        }
        return "java.lang.String";
    }

    public static Class<?> getClassObject(Object obj) throws ClassNotFoundException {
        Class<?> theClass = Class.forName(getDataType(obj));
        return theClass;
    }

    public static  ConcurrentHashMap<Class<?>, Class<?>>  createMap(Object key,Object value) throws ClassNotFoundException {
        Class<?> keyObj=DataTypeFactory.getClassObject(key);
        Class<?> valueObj=DataTypeFactory.getClassObject(value);
        System.out.println(keyObj);
        System.out.println(valueObj);
       ConcurrentHashMap<Class<?>, Class<?>> map=new ConcurrentHashMap<Class<?>,Class<?>>();
        return map;
    }

    public static List<Object> getSecondaryIndexValue(String populationLevel,ConcurrentHashMap<Object,List<ValueObject>> map) {
        List<Object> list=new ArrayList<>();
        for (Map.Entry<Object, List<ValueObject>> entry : map.entrySet()) {
            for(ValueObject s:entry.getValue()){
                if (s.getPopulationLevel()!=null&&s.getPopulationLevel().equals(populationLevel)){
                    list.add(entry.getKey());
                }
            }
        }
        return list;
    }
}
