package com.fisc.decletatfinancier2.web.rest;

import com.fisc.decletatfinancier2.service.DecletatfinancierIiKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/decletatfinancier-ii-kafka")
public class DecletatfinancierIiKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DecletatfinancierIiKafkaResource.class);

    private DecletatfinancierIiKafkaProducer kafkaProducer;

    public DecletatfinancierIiKafkaResource(DecletatfinancierIiKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
