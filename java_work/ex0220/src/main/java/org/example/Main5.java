package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main5 {

    public static void main(String[] args) throws IOException {
        // 현재 폴더
        Path fp = Paths.get("nio.txt");

        if(!Files.exists(fp))
            Files.createFile(fp);


    }
}
