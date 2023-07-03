package Goorm.Introduce.Domain.FireBase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FirebaseInitialize {
    private final ResourceLoader resourceLoader;

    public static final String DATABASE_URL = "https://test-de4c9.firebaseio.com";//추후 연결된 DB변경시 변경

}
