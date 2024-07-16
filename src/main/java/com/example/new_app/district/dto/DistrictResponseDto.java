package com.example.new_app.district.dto;

import com.example.new_app.region.entity.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictResponseDto {
    private Integer id;
    private String name;
    private Region regionId;
}