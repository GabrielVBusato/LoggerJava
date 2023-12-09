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
public class LogErrorBuilder extends LogBuilder {

    @Override
    public void formatMessage() {
        this.message = "Ocorreu a falha {" + message + "} ao realizar a operação {" + operation + "} do contato " + contactName + ", ("
                + currentDate + ", " + currentHour + ", e " + adminUsername + ")";
    }

    @Override
    public LogRegister getLog() {
        formatMessage();
        return new LogRegister(type, contactName, operation, adminUsername, message, currentDate, currentHour);
    }
}
