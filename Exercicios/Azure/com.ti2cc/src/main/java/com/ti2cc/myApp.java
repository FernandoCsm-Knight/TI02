package com.ti2cc;

import com.microsoft.azure.cognitiveservices.vision.computervision.*;
import com.microsoft.azure.cognitiveservices.vision.computervision.implementation.ComputerVisionImpl;
import com.microsoft.azure.cognitiveservices.vision.computervision.models.*;

import java.io.*;
import java.nio.file.Files;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class myApp {

    private static String key = "108539f550be47d9b82a544c74f7bbaa";
    private static String endpoint = "https://fernandocsm-img.cognitiveservices.azure.com/";

    public static void main(String[] args) {
        System.out.println("\nExercício 04 Trabalho Interdisciplinar II");

        ComputerVisionClient client = authenticate(key, endpoint); 

        analyzeRemoteImage(client);

    }

    public static ComputerVisionClient authenticate(String key, String endpoint){
        return ComputerVisionManager.authenticate(key).withEndpoint(endpoint);
    }


    public static void analyzeRemoteImage(ComputerVisionClient client) {
        String img = "https://source.unsplash.com/random/300×300";

        List<VisualFeatureTypes> features = new ArrayList<>();
        features.add(VisualFeatureTypes.TAGS);

        for(int i = 0; i < 5; i++) {
            System.out.printf("\n\nAnalizando a imagem aleatória %d...\n", i + 1);
            analyze(features, img, client);
        }
    }
    public static void analyze(List<VisualFeatureTypes> features, String img, ComputerVisionClient client) {
        try {
            ImageAnalysis analysis = client.computerVision().analyzeImage().withUrl(img)
                    .withVisualFeatures(features).execute();


            System.out.println("\nAvaliações: ");
            for (ImageTag tag : analysis.tags()) 
                System.out.printf("-- %s:  %f\n", tag.name(), tag.confidence());
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
}