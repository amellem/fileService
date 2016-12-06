package fileserviceapp;

import java.util.List;
import java.util.Map;

/**
 *
 * @author CloudAerius
 */
public interface TextFormatStrategy {

    String encodeToString(List<Map<String, String>> dataFromApp);

    List<Map<String, String>> decodeFromFile(List<String> dataFromFile);

}
