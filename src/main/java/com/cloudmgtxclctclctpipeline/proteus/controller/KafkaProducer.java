package com.cloudmgtxclctclctpipeline.proteus.controller;

import com.cloudmgtxclctclctpipeline.proteus.domain.Orders;
import com.corelogic.idap.starters.idapkafkaservicestarter.service.KafkaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class KafkaProducer {

    private KafkaService kafkaService;

    @PostMapping("/orders")
    public ResponseEntity postOrderAssigned(@RequestBody String proteusEvent) throws JsonProcessingException {

        String kafkaTopic = "orders";

        Orders order = new ObjectMapper()
                            .readerFor(Orders.class)
                            .readValue(proteusEvent);

        try {

            kafkaService.send(order, kafkaTopic);

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(order);
        }
        catch ( Exception e ) {                         // (KafkaServiceException e) {
            log.error("Failed: To Send message", e);
//            throw new RuntimeException(e);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(order);
        }
    }
}