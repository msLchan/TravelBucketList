package ui;

import model.FileNotFoundException;

// Travel Bucket List application
public class Main {
    public static void main(String[] args) {
        try {
            new TravelBucketListApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}