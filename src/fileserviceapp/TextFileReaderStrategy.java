/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileserviceapp;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author CloudAerius
 */

public interface TextFileReaderStrategy {

    String getFilePath();

    TextFormatStrategy getTextFormatStrategy();

    List<Map<String, String>> readFile() throws IOException;

    void setFilePath(String filePath);

    void setTextFormatStrategy(TextFormatStrategy textFormatStrategy);
    
}
