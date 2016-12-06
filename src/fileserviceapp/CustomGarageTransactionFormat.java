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
    public final String encodeToString(List<Map<String, String>> dataFromApp) {
        Map<String, String> sourceData = dataFromApp.get(0);
        String totalHours = sourceData.get("totalHours");
        String totalFees = sourceData.get("totalFees");

        return totalHours + RETURN_CHAR + totalFees + RETURN_CHAR;
    }

    @Override
    public final List<Map<String, String>> decodeFromFile(List<String> dataFromFile) {
        String totalHours = dataFromFile.get(0);
        String totalFees = dataFromFile.get(1);

        List<Map<String, String>> appData = new ArrayList<>();
        Map<String, String> record = new HashMap<>();
        record.put("totalHours", totalHours);
        record.put("totalFees", totalFees);
        appData.add(record);

        return appData;
    }
}
