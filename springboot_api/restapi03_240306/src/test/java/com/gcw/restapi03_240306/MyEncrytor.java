package com.gcw.restapi03_240306;

import jakarta.validation.Valid;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

public class MyEncrytor {

    //@Value("&{jaspyt.encryptor.password}")
    private String password = "passw@rdpassw@rdpassw@rdpassw@rdpassw@rdpassw@rdpassw@rdpassw@rdpassw@rdpassw@rdpassw@rdpassw@rdpassw@rd";

    @Test
    void name() {
        System.out.println("실행됩니다" + password);

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);

        String content = "root";
        String encString = encryptor.encrypt(content);
        String decString = encryptor.decrypt(encString);
        System.out.println(String.format("root encString = %s decString = %s", encString, decString));


    }

}
