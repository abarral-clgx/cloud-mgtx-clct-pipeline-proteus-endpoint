package com.cloudmgtxclctclctpipeline.proteus.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProteusEventsControllerIntegrationTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void postProteusEvent() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("content-type", MediaType.APPLICATION_JSON.toString());

        String proteusEvent = "{\n" +
                "    \"sourceId\": \"CollateralHQTest\",\n" +
                "    \"eventId\": \"OrderAssigned\",\n" +
                "    \"correlationId\": \"D9104FDB-C08D-498D-872D-4A519C0E4EFE\",\n" +
                "    \"body\": {\n" +
                "\n" +
                "        \"clientId\": \"167\",\n" +
                "        \"sourceClientId\": \"135\",\n" +
                "        \"folderId\": \"20210203-0177\",\n" +
                "        \"loanNumber\": \"980003111685\",\n" +
                "        \"loanPurposeId\": null,\n" +
                "        \"loanPurposeDescription\": null,\n" +
                "        \"loanClassification\": null,\n" +
                "        \"channelId\": null,\n" +
                "        \"channelDescription\": null,\n" +
                "        \"customer\": null,\n" +
                "        \"propertyTypeId\": null,\n" +
                "        \"propertyTypeDescription\": null,\n" +
                "        \"streetNumber\": null,\n" +
                "        \"street\": null,\n" +
                "        \"unitNumber\": null,\n" +
                "        \"city\": null,\n" +
                "        \"state\": null,\n" +
                "        \"county\": null,\n" +
                "        \"zipCode\": null,\n" +
                "        \"documentId\": \"20210203-0177-1\",\n" +
                "        \"serviceId\": null,\n" +
                "        \"serviceName\": null,\n" +
                "        \"serviceProviderLoginId\": null,\n" +
                "        \"serviceProviderId\": \"70467\",\n" +
                "        \"serviceProviderName\": null,\n" +
                "        \"serviceProviderFee\": null,\n" +
                "        \"reviewer\": null,\n" +
                "        \"processor\": null,\n" +
                "        \"loanOfficer\": null,\n" +
                "        \"appraisedValue\": null,\n" +
                "        \"appraisalScore\": null,\n" +
                "        \"cURiskScore\": null,\n" +
                "        \"complexityScore\": null\n" +
                "    }\n" +
                "}";

        HttpEntity<String> request = new HttpEntity<String>(proteusEvent, headers);

        //ResponseEntity responseEntity = restTemplate.exchange("/orderassigned", HttpMethod.POST, request, Orders.class);

        //assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
    }
}
