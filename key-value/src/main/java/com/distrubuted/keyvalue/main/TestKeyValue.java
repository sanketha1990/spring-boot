package com.distrubuted.keyvalue.main;

import com.distrubuted.keyvalue.dto.ValueObject;
import com.distrubuted.keyvalue.util.CustomList;
import com.distrubuted.keyvalue.util.DataTypeFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestKeyValue {
    public static void main(String[] args) throws ClassNotFoundException {

        String test="java.lang.String";
        Class<?> theClass = Class.forName(test);
        //System.out.println(theClass);

        ConcurrentHashMap<Object,List<ValueObject>> map=new ConcurrentHashMap<Object,List<ValueObject>>();

        List<ValueObject> list=new ArrayList<>();
        ValueObject vo1=new ValueObject();
        vo1.setPopulationLevel("high");
        vo1.setPopulation("20.0");
        list.add(vo1);
        map.put("Delhi",list);

        ValueObject vo2=new ValueObject();
        vo2.setPopulationLevel("high");
        vo2.setLangitude("-2.0");
        vo2.setLatititude("106");
        list.add(vo2);
        map.put("Jakartha",list);

        ValueObject vo3=new ValueObject();
        vo3.setPopulationLevel("Medium");
        vo3.setLangitude("12.5");
        vo3.setLatititude("77.69");
        list.add(vo3);
        map.put("Banglure",list);

        System.out.println(map);

        List<Object> secondaryIndex=DataTypeFactory.getSecondaryIndexValue("high",map);
        System.out.println(secondaryIndex);


    }
}
