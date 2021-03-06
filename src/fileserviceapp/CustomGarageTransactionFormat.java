package fileserviceapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author CloudAerius
 */
public class CustomGarageTransactionFormat implements TextFormatStrategy {

    private final String RETURN_CHAR = "\n";

    @Override
    public final String encodeToString(List<Map<String, String>> appData) {
        Map<String, String> sourceData = appData.get(0);
        String totalHours = sourceData.get("totalHours");
        String totalFees = sourceData.get("totalFees");

        return totalHours + RETURN_CHAR + totalFees + RETURN_CHAR;
    }

    @Override
    public final List<Map<String, String>> decodeFromFile(List<String> fileData) {
        String totalHours = fileData.get(0);
        String totalFees = fileData.get(1);

        List<Map<String, String>> appData = new ArrayList<>();
        Map<String, String> record = new HashMap<>();
        record.put("totalHours", totalHours);
        record.put("totalFees", totalFees);
        appData.add(record);

        return appData;
    }
}
