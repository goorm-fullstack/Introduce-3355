package Goorm.Introduce;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.*;

@SpringBootApplication
public class IntroduceApplication {
	private static final ResourceLoader resourceLoader = new DefaultResourceLoader();
	public static final String DATABASE_URL = "https://test-de4c9.firebaseio.com";//추후 연결된 DB변경시 변경
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("Key/testKey.json");
			try {
				InputStream input = resource.getInputStream();
				FirebaseOptions options = new FirebaseOptions.Builder()
						.setCredentials(GoogleCredentials.fromStream(input))
						.setDatabaseUrl(DATABASE_URL)
						.build();
				FirebaseApp.initializeApp(options);
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		SpringApplication.run(IntroduceApplication.class, args);
	}

}
