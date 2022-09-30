package com.kuehne.citiesapp.service;

import com.kuehne.citiesapp.entity.City;
import com.kuehne.citiesapp.repository.CityRepository;
import com.kuehne.citiesapp.util.FileUtil;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class CityService {
    CityRepository cityRepository;

    /**
     * Get all city list
     *
     * @return city list
     */
    public List<City> getCities() {
        return cityRepository.findAll();
    }

    /**
     * Get cities by name entered by user
     *
     * @param name passed by user
     * @return
     */
    public City getCityByName(String name) {
        return cityRepository.findByName(name);
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
    public City updateCity(City city) {
        return cityRepository.save(city);
    }
}
