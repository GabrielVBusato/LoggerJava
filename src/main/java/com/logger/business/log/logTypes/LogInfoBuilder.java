/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logger.business.log.logTypes;

import com.logger.models.LogRegister;

/**
 *
 * @author busat
 */
public class LogInfoBuilder extends LogBuilder {

    private String formatedOperation;

    @Override
    public void formatMessage() {
        this.message = formatedOperation + ": " + contactName + ", "
                + "(" + currentDate + ", " + currentHour + ", e " + adminUsername + ")";
    }

    @Override
    public void setOperation(String operation) {
        super.setOperation(operation);
        if (operation != null) {
            this.formatedOperation = operation.substring(0, 1).toUpperCase() + operation.substring(1);
        }
    }

    @Override
    public LogRegister getLog() {
        formatMessage();
        return new LogRegister(type, contactName, operation, adminUsername, message, currentDate, currentHour);
    }
}
