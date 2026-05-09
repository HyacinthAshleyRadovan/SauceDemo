package utils;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

public class jsonReader {

    public static JSONObject getJsonData(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            return new JSONObject(content);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file");
        }
    }
}