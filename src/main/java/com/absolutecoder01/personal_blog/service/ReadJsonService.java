package com.absolutecoder01.personal_blog.service;

import net.minidev.json.writer.JsonReader;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.Map;

public class ReadJsonService {
    public static void readFromJson() throws Exception {
        InputStream inStream = JsonReader.class.getResourceAsStream("/" + "your_config_file.json");
        Map<String, String> keyValueMap =
                new ObjectMapper().readValue(inStream, new TypeReference<Map<String, String>>() {});
        assert inStream != null;
        inStream.close();
    }
}