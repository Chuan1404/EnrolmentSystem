/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.configs;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import java.io.IOException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author AnChuPC
 */
@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("classpath:serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://enrolmentsystem-383911.firebaseio.com")
                .build();
        FirebaseApp.initializeApp(options);
        return FirebaseApp.getInstance();
    }
}
