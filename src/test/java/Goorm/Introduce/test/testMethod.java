package Goorm.Introduce.test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileWriter;
import java.io.IOException;

public class testMethod {
    @Value("firebase.apiKey")
    private static String jsonString;

    @Test
    void testMethod() {
        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(jsonString);
        Resource resource = new ClassPathResource("Key/testKey.json");
        FileWriter file = null;
        try {
            file = new FileWriter(resource.getURI().getPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            file.write(object.getAsString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertThat(file).isNull();
    }
}
