package com.example.new_app.district.dto;

import com.example.new_app.region.entity.Region;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictCreateDto {

    private String name;
    private Region regionId;
}
