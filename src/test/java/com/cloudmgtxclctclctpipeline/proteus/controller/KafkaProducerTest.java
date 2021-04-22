package com.cloudmgtxclctclctpipeline.proteus.controller;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

class KafkaProducerTest {
    @BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void postOrderAssigned() throws IOException {
        byte[] fileContent = Files.readAllBytes(Paths.get("c:/proteus-secrets/dev-cld-mgtx-clc-svc.keytab"));

        System.out.println(Base64.getEncoder().encodeToString(fileContent));
    }
}