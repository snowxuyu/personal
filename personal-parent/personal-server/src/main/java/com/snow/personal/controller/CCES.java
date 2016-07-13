package com.snow.personal.controller;

import java.lang.reflect.Field;

/**
 * Created by snowxuyu on 2016/7/5.
 */
public class CCES {
    public static void main(String[] args){
        System.out.println(Integer.class.getTypeName());
        Field[] declaredFields = Integer.class.getDeclaredFields();
        String typeName = declaredFields[2].getGenericType().getTypeName();
        String substring = typeName.substring(16,33);
        System.out.println(substring);
        //List<Field> fields = Arrays.asList(declaredFields);
        //System.out.println(fields.get(2).getGenericType().getTypeName());
        //fields.forEach(o -> System.out.println(o.getGenericType().getTypeName()));
    }

}
