package utils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;
import org.apache.commons.io.IOUtils;

public class jsonReader {

    public static JSONObject getJsonData(String fileName) {
        try {
            InputStream is = jsonReader.class
                    .getClassLoader()
                    .getResourceAsStream(fileName);

            if (is == null) {
                throw new RuntimeException("File not found: " + fileName);
            }

            String content = IOUtils.toString(is, StandardCharsets.UTF_8);

            return new JSONObject(content);

        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file", e);
        }
    }
}