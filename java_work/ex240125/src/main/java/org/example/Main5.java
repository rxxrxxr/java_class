package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main5 {

    public static void doA() {
        Path file = Paths.get("a.txt");
        try (BufferedWriter bw = Files.newBufferedWriter(file)) {
            // finally와 똑같은 효과
            bw.write("A");
            bw.write("Z");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try {
            doA();
        } catch (Exception ae) {
            ae.printStackTrace();
        }

    }
}
