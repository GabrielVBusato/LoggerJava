package com.logger.factories;

import com.logger.business.log.adapters.LogAdapter;
import com.logger.helpers.enums.FileTypeEnum;
import java.lang.reflect.Constructor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author busat
 */
public class LogFactory {

    public static LogAdapter createrLogger(FileTypeEnum fileType,
            String filename) throws Exception {
        LogAdapter adapter;
        String className = "com.logger.business.log.adapters." + fileType + "LogAdapter";

        Class<?> loggerClass = Class.forName(className);

        Constructor<?> constructor = loggerClass.getDeclaredConstructor(String.class);

        adapter = (LogAdapter) constructor.newInstance(filename);

        return adapter;
    }
}
