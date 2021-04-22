package com.cloudmgtxclctclctpipeline.proteus.controller;

import com.corelogic.clp.orders.dto.Orders;
import com.corelogic.ebs.billing.event.pipeline.starter.service.KafkaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaService kafkaService;

    @PostMapping("/orders")
    public String postOrderAssigned(@RequestBody String proteusEvent) throws JsonProcessingException {

        Orders orders = Orders.newBuilder()
                .setAppraisedValue(100.00)
                .setClientId("clientID")
                .setSourceClientId("SourceClientID")
                .setEventId("EventId")
                .setComplexityScore(200)
                .setFolderId("Folderid")
                .setLoanNumber("LoanNumber")
                .setSourceId("SourceId")
                .setCorrelationId("CorrelationId")
                .setDocumentId("DocumentId")
                .build();

        try {
            kafkaService.sendMessageAsync(orders);
            return "Ok";
        }
        catch ( Exception e ) {                         // (KafkaServiceException e) {
            log.error("Failed: To Send message", e);
            return "Failed";
        }
    }
}