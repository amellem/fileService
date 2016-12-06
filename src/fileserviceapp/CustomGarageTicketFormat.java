package fileserviceapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author CloudAerius
 */
public class CustomGarageTicketFormat implements TextFormatStrategy {

    private final String DELIMITER = ",";
    private final String RETURN_CHAR = "\n";

    @Override
    public final String encodeToString(List<Map<String, String>> appData) {
        Map<String, String> sourceData = appData.get(0);
        String ticketNumber = sourceData.get("ticketNumber");
        String hoursParked = sourceData.get("hoursParked");
        String totalFee = sourceData.get("totalFee");

        return ticketNumber + DELIMITER + hoursParked + DELIMITER + totalFee + RETURN_CHAR;
    }

    @Override
    public final List<Map<String, String>> decodeFromFile(List<String> fileData) {
        List<Map<String, String>> appData = new ArrayList<>();
        for (int i = 0; i < fileData.size() - 1; i++) {
            String[] parts = fileData.get(i).split(DELIMITER);
            String ticketNumber = parts[0];
            String hoursParked = parts[1];
            String totalFee = parts[2];

            Map<String, String> record = new HashMap<>();
            record.put("ticketNumber", ticketNumber);
            record.put("hoursParked", hoursParked);
            record.put("totalFee", totalFee);
            appData.add(record);
        }
        return appData;
    }
}
