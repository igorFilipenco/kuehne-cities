package com.kuehne.citiesapp.service;

import com.kuehne.citiesapp.dto.CityDto;
import com.kuehne.citiesapp.dto.CityListDto;
import com.kuehne.citiesapp.entity.City;
import com.kuehne.citiesapp.repository.CityRepository;
import com.kuehne.citiesapp.util.FileUtil;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityService {
    CityRepository cityRepository;

    /**
     * Get all city list
     *
     * @return city list
     */
    public CityListDto getCities(int page, int size) {
        PageRequest pr = PageRequest.of(page,size);
        Page<City> dataPages = cityRepository.findAll(pr);
        return buildCityListDto(dataPages);
    }

    /**
     * Get cities by name entered by user
     *
     * @param name passed by user
     * @return
     */
    public CityDto getCityByName(String name) {
        return buildCityDto(cityRepository.findByName(name));
    }

    /**
     * @param file - passed by user in csv format
     * @return list of inserted cities
     * @throws IOException
     */
    @SneakyThrows
    public String uploadCitiesFromFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IOException("Upload failed - wrong file, or file format");
        } else {
            cityRepository.saveAll(FileUtil.processUploadedFile(file));
            return "file-upload-status";
        }
    }

    /**
     * Method to update city
     * @param city
     * @return
     */
    public CityDto updateCity(City city) {
        return buildCityDto(cityRepository.save(city));
    }

    private CityListDto buildCityListDto(Page<City> dataPages) {
        return CityListDto.builder()
                .data(dataPages.getContent().stream()
                        .map(this::buildCityDto)
                        .collect(Collectors.toList()))
                .page(dataPages.getNumber())
                .total(dataPages.getTotalElements())
                .build();
    }

    private CityDto buildCityDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .image(city.getImage())
                .build();
    }
}
