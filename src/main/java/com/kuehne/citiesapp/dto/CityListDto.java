package com.kuehne.citiesapp.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class CityListDto {
    private List<CityDto> data;
    private long page;
    private long total;
}
