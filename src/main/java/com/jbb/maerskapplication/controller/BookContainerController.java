package com.jbb.maerskapplication.controller;

import com.jbb.maerskapplication.Entity.Bookings;
import com.jbb.maerskapplication.Repository.BookingsRepository;
import com.jbb.maerskapplication.model.ContainerDetails;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
@RequestMapping("api/bookcontainer")
@Slf4j
public class BookContainerController {

    @Autowired
    BookingsRepository bookRepository;

    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> bookContainer(@RequestBody ContainerDetails containerDetails) throws IOException, JSONException {
        String timeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssz").format(ZonedDateTime.now());
        Bookings bookings = bookRepository.save(new Bookings(UUID.randomUUID(), containerDetails.getContainerType(), containerDetails.getOrigin(), containerDetails.getDestination(), containerDetails.getQuantity(), timeStamp));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("“bookingRef”", bookings.getBookingRef());
        return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
    }
}