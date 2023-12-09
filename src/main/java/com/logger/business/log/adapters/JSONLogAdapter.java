/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logger.business.log.adapters;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.logger.models.LogRegister;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author busat
 */
public class JSONLogAdapter extends LogAdapter {

    public JSONLogAdapter(String fileName) {
        super(fileName + ".json");
    }

    private ObjectMapper mapper;
    private ObjectWriter writer;

    @Override
    public void write(LogRegister... logRegisters) throws IOException {

        mapper = new ObjectMapper();
        writer = mapper.writer(new DefaultPrettyPrinter());

        List<LogRegister> registerList = readOldRegisters(mapper);

        registerList.addAll(Arrays.asList(logRegisters));

        writer.writeValue(file, registerList);
    }

    private List<LogRegister> readOldRegisters(ObjectMapper mapper) {
        List<LogRegister> registerList;
        try {
            registerList = mapper.readValue(file, new TypeReference<List<LogRegister>>() {
            });
        } catch (IOException e) {
            registerList = new ArrayList<>();
        }
        return registerList;
    }

}
