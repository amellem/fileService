
package fileserviceapp;
import java.util.List;
import java.util.Map;
/**
 *
 * @author CloudAerius
 */

public interface TextFormatStrategy {

    /**
     * This method takes a List of Strings and converts them into a List of Maps.
     * Each entry in the Maps contains two strings, an ID and a value. This is a
     * suitable method for converting data in from a file to a format easily used 
     * in the program.
     * @param dataFromFile a List of Strings .
     * @return a List of Maps. Each Map contains two strings, an ID and a value.
     */
    List<Map<String, String>> decodeFromFile(List<String> dataFromFile);

    /**
     * This method takes a list of Maps that contains Strings and converts them to
     * a String. This method is suitable for converting Data back to a format that can
     * be written to a file.
     * @param dataFromApp a List of Maps. Each Map will contain strings with an ID and value.
     * @return a String.
     */
    String encodeToString(List<Map<String, String>> dataFromApp);
    
}
