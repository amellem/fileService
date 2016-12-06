/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileserviceapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
/**
 *
 * @author CloudAerius
 */

public class TextFileWriterService implements TextFileWriterStrategy {
    private TextFormatStrategy textFormatStrategy;
    private String filePath;
    private boolean append;

    public TextFileWriterService(TextFormatStrategy textFormatStrategy, String filePath, boolean append) {
        this.textFormatStrategy = textFormatStrategy;
        this.filePath = filePath;
        this.append = append;
    }
    
    @Override
    public final void writeFile(List<Map<String, String>> dataFromApp) throws IOException {
        PrintWriter fileOutput = new PrintWriter(new BufferedWriter(new FileWriter(filePath, append)));
        fileOutput.print(textFormatStrategy.encodeToString(dataFromApp));
        fileOutput.close();
    }

    @Override
    public TextFormatStrategy getTextFormatStrategy() {
        return textFormatStrategy;
    }

    @Override
    public void setTextFormatStrategy(TextFormatStrategy textFormatStrategy) {
        this.textFormatStrategy = textFormatStrategy;
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean isAppend() {
        return append;
    }

    @Override
    public void setAppend(boolean append) {
        this.append = append;
    }
}
