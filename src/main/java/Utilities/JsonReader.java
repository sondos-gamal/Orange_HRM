package Utilities;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.FileReader;

public class JsonReader {
    private static final Gson GSON = new Gson();
    private static final String RESOURCES = System.getProperty("user.dir") + "/src/resources/";


    public static JsonObject read(String fileName) {
        try (FileReader reader = new FileReader(RESOURCES + fileName)) {
            return GSON.fromJson(reader, JsonObject.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file: " + fileName, e);
        }
    }
}

