package com.example.new_app.quarter.dto;

import com.example.new_app.district.entity.District;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuarterResponseDto {

    private Integer id;
    private String name;
    private District districtId;
}
