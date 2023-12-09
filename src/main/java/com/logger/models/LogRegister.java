package com.logger.models;

import com.logger.helpers.enums.LogTypeEnum;

public final class LogRegister {

    LogTypeEnum type;
    String contactName;
    String currentDate;
    String currentHour;
    String adminUsername;
    String message;
    String operation;
    
    public LogRegister() {
        
    }

    public LogRegister(String message, String currentHour, String currentDate, LogTypeEnum type) {
        this.message = message;
        this.currentHour = currentHour;
        this.currentDate = currentDate;
        this.type = type;
    }

    public LogRegister(LogTypeEnum type,
            String contactName,
            String operation,
            String adminUsername,
            String message,
            String currentDate,
            String currentHour) {
        this.type = type;
        this.operation = operation;
        this.message = message;
        this.contactName = contactName;
        this.currentDate = currentDate;
        this.currentHour = currentHour;
        this.adminUsername = adminUsername;
    }

    public String getOperation() {
        return operation;
    }

    public LogTypeEnum getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String getContactName() {
        return contactName;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public String getCurrentHour() {
        return currentHour;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setType(LogTypeEnum type) {
        this.type = type;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public void setCurrentHour(String currentHour) {
        this.currentHour = currentHour;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "LogRegister{" + "type=" + type + ", contactName=" + contactName + ", currentDate=" + currentDate + ", currentHour=" + currentHour + ", adminUsername=" + adminUsername + ", message=" + message + ", operation=" + operation + '}';
    }

}
