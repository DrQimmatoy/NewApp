package com.example.new_app.district;

import com.example.new_app.country.entity.Country;
import com.example.new_app.district.dto.DistrictCreateDto;
import com.example.new_app.district.entity.District;
import com.example.new_app.quarter.dto.QuarterCreateDto;
import com.example.new_app.quarter.entity.Quarter;
import com.example.new_app.region.entity.Region;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
@RequiredArgsConstructor
@Service
public class DistrictService {
    private final DistrictRepository districtRepository;

    @Transactional
    public List<District> getAllDistrict() {
        return districtRepository.findAll();
    }

    @Transactional
    public void create(DistrictCreateDto districtCreateDto) {

        District district = new District(null, districtCreateDto.getName(),districtCreateDto.getRegionId());
        districtRepository.save(district);
    }
    @Transactional
    public District getById(Integer id){
        return districtRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("District id" + id + "Not fount"));

    }
    @Transactional
    public void deleteById(Integer id) {
        districtRepository.deleteById(id);
    }

    @Transactional
    public void update(@ModelAttribute DistrictCreateDto districtCreateDto, @NonNull Integer id) {
        District district = districtRepository.findById(id).orElseThrow();
        district.setName(districtCreateDto.getName());
        district.setRegionId(districtCreateDto.getRegionId());
        districtRepository.save(district);

    }

    public Iterable<District>saveAll(List<District>districts){
        return districtRepository.saveAll(districts);
    }
}