package com.example.new_app.quarter.dto;

import com.example.new_app.district.entity.District;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuarterCreateDto {

    private String name;
    private District districtId;
}
