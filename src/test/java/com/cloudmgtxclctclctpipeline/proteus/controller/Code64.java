package com.cloudmgtxclctclctpipeline.proteus.controller;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Code64 {
    @Test
    void TestCode64() throws IOException {
        byte[] fileContent = Files.readAllBytes(Paths.get("c:/proteus-secrets/dev-cld-mgtx-clc-svc.keytab"));

        System.out.println(Base64.getEncoder().encodeToString(fileContent));
    }
}
