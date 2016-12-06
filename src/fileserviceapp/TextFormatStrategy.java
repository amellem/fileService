package fileserviceapp;

import java.util.List;
import java.util.Map;

/**
 *
 * @author CloudAerius
 */
public interface TextFormatStrategy {

    String encodeToString(List<Map<String, String>> appData);

    List<Map<String, String>> decodeFromFile(List<String> fileData);

}
