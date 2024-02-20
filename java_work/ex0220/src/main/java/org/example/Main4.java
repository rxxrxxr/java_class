package org.example;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main4 {
    public static void main(String[] args) throws Exception {
        Path org = Paths.get("nio.txt");
        if (!Files.exists(org))
            Files.createFile(org);

        Path dst = Paths.get("niocopy.txt");

        // 파일 복사를 해라, 있으면 대체해라
        Files.copy(org, dst, StandardCopyOption.REPLACE_EXISTING);
        Files.move(Paths.get("aaa.txt"), Paths.get("bbb.txt"), StandardCopyOption.REPLACE_EXISTING);
    }
}