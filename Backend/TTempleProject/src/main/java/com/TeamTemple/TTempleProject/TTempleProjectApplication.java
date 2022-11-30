package com.TeamTemple.TTempleProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class TTempleProjectApplication {

	public static void main(String[] args) throws IOException {
		ClassLoader classLoader = TTempleProjectApplication.class.getClassLoader();
		
		InputStream fstream = TTempleProjectApplication.class.getResourceAsStream("/serviceAccountKey.json");

//		File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile());
//
//		FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(fstream)).build();

		FirebaseApp.initializeApp(options);

		SpringApplication.run(TTempleProjectApplication.class, args);
	}

}
