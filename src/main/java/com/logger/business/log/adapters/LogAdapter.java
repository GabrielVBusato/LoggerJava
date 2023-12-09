package com.logger.business.log.adapters;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.logger.models.LogRegister;
import java.io.File;
import java.io.IOException;

public abstract class LogAdapter {

    protected File file;

    public abstract void write(LogRegister... logRegister) throws IOException;

    public LogAdapter(String fileName) {
        this.file = new File(fileName);
    }

}
