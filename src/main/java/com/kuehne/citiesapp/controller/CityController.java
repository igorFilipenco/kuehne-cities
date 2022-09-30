package com.kuehne.citiesapp.controller;

import com.kuehne.citiesapp.entity.City;
import com.kuehne.citiesapp.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class CityController {
    private CityService cityService;

    @GetMapping(value = "/city", produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
    public ResponseEntity<List<City>> getCities(@RequestHeader HttpHeaders headers) {
        return ResponseEntity.ok().body(cityService.getCities());
    }

    @GetMapping(value = "/city/{name}", produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
    public ResponseEntity<City> getCity(@Valid @PathVariable String name) {
        return ResponseEntity.ok().body(cityService.getCityByName(name));
    }

    @PostMapping(value = "/city/upload-from-file", produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
    public ResponseEntity<String> uploadCitiesFromFile(@Validated @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok().body(cityService.uploadCitiesFromFile(file));
    }

    @PutMapping(value = "/city/update", produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
    public ResponseEntity<City> updateCity(@RequestBody City city) {
        return ResponseEntity.ok().body(cityService.updateCity(city));
    }
}
