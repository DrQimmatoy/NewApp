package com.example.new_app.region.dto;

import com.example.new_app.country.entity.Country;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionCreateDto {

    private String name;
    private Country country;
}
