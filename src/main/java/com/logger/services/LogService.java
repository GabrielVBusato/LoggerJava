package com.logger.services;

import com.logger.business.log.adapters.LogAdapter;
import com.logger.business.log.logTypes.LogBuilder;
import com.logger.business.log.logTypes.LogExceptionBuilder;
import com.logger.business.log.structure.LogDirector;
import com.logger.factories.LogFactory;
import com.logger.helpers.enums.FileTypeEnum;
import com.logger.helpers.enums.LogTypeEnum;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author busat
 */
public class LogService {

    private final LogDirector director;
    private static FileTypeEnum fileType;

    public LogService(
            LogDirector director) {
        this.director = director;
        fileType = Enum.valueOf(FileTypeEnum.class, 
                Dotenv.load().get("LOG_FILE_TYPE"));
    }
    
    public void setFileType(FileTypeEnum fileType){
        System.setProperty("LOG_FILE_TYPE", fileType.name());
        LogService.fileType = fileType;
    }

    public static void writeExceptionFileLog(Exception ex) {
        try {
            LogBuilder exceptionLoggerBuilder = new LogExceptionBuilder();
            LogDirector directorException = new LogDirector(ex.getMessage() + ". StackTrace:" + Arrays.toString(ex.getStackTrace()));
            directorException.constructExceptionLogger(exceptionLoggerBuilder);
            LogAdapter logger = LogFactory.createrLogger(fileType, "exceptions");
            logger.write(exceptionLoggerBuilder.getLog());
        } catch (Exception expt) {
            System.out.println(expt.getMessage());
        }
    }

    public void writeSystemLogFile(
            LogTypeEnum type,
            LogBuilder builder) {
        try {
            director.constructLogger(builder, type);
            LogAdapter logger = LogFactory.createrLogger(fileType, "log");
            logger.write(builder.getLog());
        } catch (Exception ex) {
            writeExceptionFileLog(ex);
        }
    }
}
