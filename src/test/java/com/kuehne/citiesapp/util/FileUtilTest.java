package com.kuehne.citiesapp.util;

import com.kuehne.citiesapp.entity.City;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FileUtilTest {

    private static MultipartFile csvMock;

    @BeforeAll
    static void setup() {
        final ClassLoader classLoader = FileUtilTest.class.getClassLoader();
        final String resourceName = "src/test/resources/file/citiesMock.csv";
        try {
            csvMock = new MockMultipartFile("testFile", new FileInputStream(resourceName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Test if method returns list of records with same number(5) as contains mock")
    void processUploadedFileUsingValidCSV() {
        List<City> cities =  FileUtil.processUploadedFile(csvMock);
        assertEquals(5, cities.size());
        assertEquals("Tokyo", cities.get(0).getName());
    }
}