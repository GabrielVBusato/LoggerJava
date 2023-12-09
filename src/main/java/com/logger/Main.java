/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.logger;

import com.logger.business.log.logTypes.LogBuilder;
import com.logger.business.log.structure.LogDirector;
import com.logger.business.log.logTypes.LogErrorBuilder;
import com.logger.business.log.logTypes.LogInfoBuilder;
import com.logger.helpers.enums.FileTypeEnum;
import com.logger.helpers.enums.LogTypeEnum;
import com.logger.services.LogService;

/**
 *
 * @author busat
 */
public class Main {

    public static void main(String[] args) {
        try {
            LogBuilder errorLogger = new LogErrorBuilder();
            LogBuilder infoLogger = new LogInfoBuilder();

            LogDirector director = new LogDirector("Paulo",
                    "usuário já cadastrado", "Gabriel", "adicionar usuário");

            LogService service = new LogService(director);
            service.writeSystemLogFile(LogTypeEnum.ERROR, infoLogger);
            
            service.setFileType(FileTypeEnum.JSON);

            director.setContactName("Mauricio");            
            
            service.writeSystemLogFile(LogTypeEnum.ERROR, infoLogger);
            service.writeSystemLogFile(LogTypeEnum.INFO, errorLogger);
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}
