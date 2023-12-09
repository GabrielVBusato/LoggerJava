/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logger.business.log.structure;

import com.logger.helpers.enums.LogTypeEnum;
import com.logger.business.log.logTypes.LogBuilder;

/**
 *
 * @author busat
 */
public class LogDirector {

    private String adminUserName;
    private String message;
    private String contactName;
    private String operation;

    public LogDirector(String errorMessage) {
        this.message = errorMessage;
    }

    public LogDirector(String adminUserName,
            String message,
            String contactName,
            String operation) {
        this.adminUserName = adminUserName;
        this.message = message;
        this.contactName = contactName;
        this.operation = operation;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }
    
    public void setMessage(String message){
        this.message = message;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void constructLogger(LogBuilder builder, LogTypeEnum type) {
        builder.setType(type);
        builder.setAdminUserName(adminUserName);
        builder.setMessage(message);
        builder.setContactName(contactName);
        builder.setOperation(operation);
    }
    
    public void constructExceptionLogger(LogBuilder builder){
        builder.setMessage(message);
        builder.setType(LogTypeEnum.EXCEPTION);
    }
    
    
}
