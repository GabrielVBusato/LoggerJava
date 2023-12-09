/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logger.business.log.logTypes;

import com.logger.helpers.enums.LogTypeEnum;
import com.logger.models.LogRegister;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author busat
 */
public abstract class LogBuilder {
    protected LogTypeEnum type;
    protected String contactName;
    protected String adminUsername;
    protected String message;
    protected String currentHour;
    protected String currentDate;
    protected String operation;
    
    public LogBuilder(){
        setDates();
    }

    public abstract void formatMessage();
        
    public abstract LogRegister getLog();
    
    public final void setDates(){
        LocalDateTime now = LocalDateTime.now();
        this.currentDate = now.format(DateTimeFormatter.ofPattern("dd/MM/yy"));
        this.currentHour = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
    
    public void setMessage(String message){
        this.message = message;
    }
    
    public void setType(LogTypeEnum type) {
        this.type = type;
    }
    
    public void setOperation(String operation){
        this.operation = operation;
    }

    public void setContactName(String name) {
        this.contactName = name;
    }

    public void setAdminUserName(String username) {
        this.adminUsername = username;
    }
}
