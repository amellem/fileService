package fileserviceapp;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author CloudAerius
 */
public class FileService {

    private TextFileReaderStrategy textFileReaderStrategy;
    private TextFileWriterStrategy textFileWriterStrategy;

    public FileService(TextFileReaderStrategy textFileReaderStrategy) {
        this.textFileReaderStrategy = textFileReaderStrategy;
    }

    public FileService(TextFileWriterStrategy textFileWriterStrategy) {
        this.textFileWriterStrategy = textFileWriterStrategy;
    }

    public FileService(TextFileReaderStrategy textFileReaderStrategy, TextFileWriterStrategy textFileWriterStrategy) {
        this.textFileReaderStrategy = textFileReaderStrategy;
        this.textFileWriterStrategy = textFileWriterStrategy;
    }

    public TextFileReaderStrategy getTextFileReaderStrategy() {
        return textFileReaderStrategy;
    }

    public void setTextFileReaderStrategy(TextFileReaderStrategy textFileReaderStrategy) {
        this.textFileReaderStrategy = textFileReaderStrategy;
    }

    public TextFileWriterStrategy getTextFileWriterStrategy() {
        return textFileWriterStrategy;
    }

    public void setTextFileWriterStrategy(TextFileWriterStrategy textFileWriterStrategy) {
        this.textFileWriterStrategy = textFileWriterStrategy;
    }

    public List<Map<String, String>> readFile() throws IOException {
        return textFileReaderStrategy.readFile();
    }

    public void writeFile(List<Map<String, String>> dataFromApp) throws IOException {
        textFileWriterStrategy.writeFile(dataFromApp);
    }
}
