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
        String ticketNumber = "T1";
        String totalHours = "3";
        String totalFees = "21.50";
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

            System.out.println("File write error");
        }

        try {
            List<Map<String, String>> appData = fileService.readFile();
            System.out.println(appData.size());
        } catch (IOException ex) {

            System.out.println("File read error");
        }
    }
}
