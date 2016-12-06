package fileserviceapp;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author CloudAerius
 */
public interface TextFileWriterStrategy {

    String getFilePath();

    TextFormatStrategy getTextFormatStrategy();

    boolean isAppend();

    void setAppend(boolean append);

    void setFilePath(String filePath);

    void setTextFormatStrategy(TextFormatStrategy textFormatStrategy);

    void writeFile(List<Map<String, String>> dataFromApp) throws IOException;

}
