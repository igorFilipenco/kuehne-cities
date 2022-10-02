package com.kuehne.citiesapp.controller;

import com.kuehne.citiesapp.dto.CityDto;
import com.kuehne.citiesapp.dto.CityListDto;
import com.kuehne.citiesapp.entity.City;
import com.kuehne.citiesapp.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.kuehne.citiesapp.constant.Constants.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class CityController {
    private CityService cityService;

    @GetMapping(value = "/city", produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
    public ResponseEntity<CityListDto> getCities(@RequestParam(defaultValue = CITY_PAGE_DEFAULT_PAGE) int page,
                                                 @RequestParam(defaultValue = CITY_PAGE_SIZE) int size) {
        return ResponseEntity.ok().body(cityService.getCities(page, size));
    }

    @GetMapping(value = "/city/search", produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
    public ResponseEntity<CityListDto> getCity(@Valid @RequestParam String name) {
        return ResponseEntity.ok().body(cityService.getCityByName(name));
    }

    @PostMapping(value = "/city/upload-from-file", produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
    public ResponseEntity<String> uploadCitiesFromFile(@Valid @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok().body(cityService.uploadCitiesFromFile(file));
    }

    @PutMapping(value = "/city/update", produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
    public ResponseEntity<CityDto> updateCity(@RequestBody City city) {
        return ResponseEntity.ok().body(cityService.updateCity(city));
    }
}
