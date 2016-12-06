package fileserviceapp;

/**
 *
 * @author CloudAerius
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Startup {

    public static void main(String[] args) {
        String ticketNumber = "101";
        String totalHours = "6";
        String totalFees = "13.37";
        String filePath = "src" + File.separatorChar + "tickets.txt";
        TextFileReaderStrategy textFileReaderStrategy = new TextFileReaderService(new CustomGarageTicketFormat(), filePath);
        TextFileWriterStrategy textFileWriterStrategy = new TextFileWriterService(new CustomGarageTicketFormat(), filePath, true);

        FileService fileService = new FileService(textFileReaderStrategy, textFileWriterStrategy);

        //App testing
        List<Map<String, String>> dataFromApp = new ArrayList<>();
        Map<String, String> record = new HashMap<>();
        record.put("ticketNumber", ticketNumber);
        record.put("hoursParked", totalHours);
        record.put("totalFee", totalFees);
        dataFromApp.add(record);

        try {
            fileService.writeFile(dataFromApp);
        } catch (IOException ex) {
            //TODO
            System.out.println("Quick Error handling");
        }

        try {
            List<Map<String, String>> appData = fileService.readFile();
            System.out.println(appData.size());
        } catch (IOException ex) {
            //TODO
            System.out.println("Quick Error handling");
        }
    }
}
