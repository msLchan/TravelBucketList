package ui;

import java.io.FileNotFoundException;
import java.io.IOException;

// Travel Bucket List application
public class Main {
    public static void main(String[] args) {
        try {
            new TravelBucketListApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        } catch (IOException e) {
            System.out.println("Unable to run application: an I/O error occurred");
        }
    }
}