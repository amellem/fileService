package fileserviceapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author CloudAerius
 */
public class CustomGarageSettingsFormat implements TextFormatStrategy {

    private final String RETURN_CHAR = "\n";

    @Override
    public final String encodeToString(List<Map<String, String>> dataFromApp) {
        Map<String, String> sourceData = dataFromApp.get(0);
        String garageName = sourceData.get("garageName");
        String feeCalculatorOption = sourceData.get("feeCalculatorOption");

        return garageName + RETURN_CHAR + feeCalculatorOption + RETURN_CHAR;
    }

    @Override
    public final List<Map<String, String>> decodeFromFile(List<String> dataFromFile) {
        String garageName = dataFromFile.get(0);
        String feeCalculatorOption = dataFromFile.get(1);

        List<Map<String, String>> appData = new ArrayList<>();
        Map<String, String> record = new HashMap<>();
        record.put("garageName", garageName);
        record.put("feeCalculatorOption", feeCalculatorOption);
        appData.add(record);

        return appData;
    }
}
