package com.jbb.maerskapplication.controller;

import com.jbb.maerskapplication.model.ContainerDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import javax.validation.Valid;

@RestController
@RequestMapping("api/bookings")
@Slf4j
public class BookingController {

    @PostMapping(path = "/checkAvailable", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> checkAvailability(@Valid @RequestBody ContainerDetails containerDetails) {

        WebClient webClient = WebClient.create();
        String responseJson = webClient.get()
                .uri("/api/getAvailabilityDetails/getAvailabilityDetails", containerDetails)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return new ResponseEntity<>(responseJson, HttpStatus.OK);
    }

    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> bookContainer(@Valid @RequestBody ContainerDetails containerDetails) {

        WebClient webClient = WebClient.create();
        String responseJson = webClient.get()
                .uri("/api/bookcontainer", containerDetails)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return new ResponseEntity<>(responseJson, HttpStatus.OK);
    }

}
