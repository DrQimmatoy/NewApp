package com.example.new_app.quarter;

import com.example.new_app.quarter.dto.QuarterCreateDto;
import com.example.new_app.quarter.entity.Quarter;
import com.example.new_app.region.dto.RegionUpdateDto;
import com.example.new_app.region.entity.Region;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuarterService {
    private final QuarterRepository quarterRepository;

    @Transactional
    public void create(QuarterCreateDto quarterCreateDto) {
        Quarter quarter = new Quarter(null, quarterCreateDto.getName(), quarterCreateDto.getDistrictId());
        quarterRepository.save(quarter);
    }
    @Transactional
    public List<Quarter> getAllQuarter() {
        return quarterRepository.findAll();
    }
    @Transactional
    public Quarter getById(Integer id){
        return quarterRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Quarter id" + id + "Not fount"));

    }
    @Transactional
    public void deleteById(Integer id) {
        quarterRepository.deleteById(id);
    }

    @Transactional
    public void update(@ModelAttribute QuarterCreateDto quarterCreateDto, @NonNull Integer id) {
        Quarter quarter = quarterRepository.findById(id).orElseThrow();
        quarter.setName(quarterCreateDto.getName());
        quarter.setDistrictId(quarterCreateDto.getDistrictId());
        quarterRepository.save(quarter);

    }
}
