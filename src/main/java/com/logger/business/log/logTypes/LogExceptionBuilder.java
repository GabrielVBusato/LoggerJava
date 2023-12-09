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
public class LogExceptionBuilder extends LogBuilder {
     @Override
    public void formatMessage() {
        this.message = "Uma exceção ocorreu: " + message;
    }

    @Override
    public LogRegister getLog() {
        formatMessage();
        return new LogRegister(message, currentDate, currentHour, type );
    }
}
