package com.example.new_app.region.dto;

import com.example.new_app.country.entity.Country;
import com.example.new_app.district.entity.District;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionResponseDto {

    private Integer id;
    private String name;
    private Country country;
    private List<District> districts;
}
