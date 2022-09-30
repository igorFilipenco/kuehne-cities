package com.kuehne.citiesapp.controller;

import com.kuehne.citiesapp.entity.City;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class CityController {
    @GetMapping(value = "/cities", produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
    public ResponseEntity<List<City>> getCities(@RequestHeader HttpHeaders headers) {
        return ResponseEntity.ok().body(Collections.emptyList());
    }

    @GetMapping(value = "/city/{name}", produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
    public ResponseEntity<City> getCity(@PathVariable String name) {
        return null;
    }

    @PostMapping(value = "/upload-from-file", produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
    public ResponseEntity<List<City>> uploadCitiesFromFile() {
        return ResponseEntity.ok().body(Collections.emptyList());
    }
}
