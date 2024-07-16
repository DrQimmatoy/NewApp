package com.example.new_app.region.dto;

import com.example.new_app.country.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionUpdateDto {

    private String name;
    private Country country;
}
