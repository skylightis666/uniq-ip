package org.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // "src/main/resources/test1"
        var fileSorter = new FileSorter(args[0]);

        File outputFile = null;
        try {
            outputFile = fileSorter.startSort();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        var ipCounter = new IpCounter(outputFile);
        System.out.format("Answer: %d", ipCounter.count());
    }
}