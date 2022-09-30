package com.kuehne.citiesapp.util;

import com.kuehne.citiesapp.entity.City;
import lombok.experimental.UtilityClass;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Util-class to work with files
 */
@UtilityClass
public class FileUtil {
    private static final String DELIMITER = ",";

    public List<City> processUploadedFile(MultipartFile file) {
            List<City> cities = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                reader.readLine(); // skip first line with column names
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] cityData = line.split(DELIMITER);
                    cities.add(buildCity(cityData));
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        return cities;
    }

    private City buildCity(String[] cityData) {
        return City.builder()
                .name(cityData[1])
                .image(cityData[2])
                .build();
    }
}
