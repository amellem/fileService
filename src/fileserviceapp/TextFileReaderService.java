package fileserviceapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author CloudAerius
 */
public class TextFileReaderService implements TextFileReaderStrategy {

    private TextFormatStrategy textFormatStrategy;
    private String filePath;

    public TextFileReaderService(TextFormatStrategy textFormatStrategy, String filePath) {
        this.textFormatStrategy = textFormatStrategy;
        this.filePath = filePath;
    }

    @Override
    public final List<Map<String, String>> readFile() throws IOException {
        File file = new File(filePath);

        BufferedReader in = null;
        List<String> lines = new ArrayList<>();
        in = new BufferedReader(
                new FileReader(file));
        String line = "";
        while (line != null) {
            line = in.readLine();
            lines.add(line);
        }
        in.close();

        return textFormatStrategy.decodeFromFile((lines));
    }

    @Override
    public final TextFormatStrategy getTextFormatStrategy() {
        return textFormatStrategy;
    }

    @Override
    public final void setTextFormatStrategy(TextFormatStrategy textFormatStrategy) {
        this.textFormatStrategy = textFormatStrategy;
    }

    @Override
    public final String getFilePath() {
        return filePath;
    }

    @Override
    public final void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
