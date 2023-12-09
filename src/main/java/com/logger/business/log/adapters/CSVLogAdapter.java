/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logger.business.log.adapters;

import com.logger.models.LogRegister;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author busat
 */
public class CSVLogAdapter extends LogAdapter {
     private CSVWriter csvWriter;

    public CSVLogAdapter(String fileName) {
        super(fileName + ".csv");
    }

    @Override
    public void write(LogRegister... logRegisters) throws IOException {

        csvWriter = new CSVWriter(new FileWriter(file, true));

        addHeader(csvWriter);

        for (LogRegister logRegister : logRegisters) {
            String[] logString = {
                    logRegister.getOperation(),
                    logRegister.getMessage(),
                    logRegister.getContactName(),
                    logRegister.getAdminUsername(),
                    logRegister.getCurrentDate(),
                    logRegister.getCurrentHour(),
            };
            csvWriter.writeNext(logString);
        }
        csvWriter.close();
    }

    private void addHeader(CSVWriter csvWriter) {
        if (file.length() == 0) {
            csvWriter.writeNext(
                    new String[]{"operação", "mensagem", "nome do user",  "admin", "data", "hora"},
                    false
            );
        }
    }
}
