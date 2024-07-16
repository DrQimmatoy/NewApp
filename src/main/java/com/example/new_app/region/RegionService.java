package com.example.new_app.region;

import com.example.new_app.region.dto.RegionCreateDto;
import com.example.new_app.region.dto.RegionUpdateDto;
import com.example.new_app.region.entity.Region;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository regionRepository;
    @Transactional
    public List<Region> getAllRegion() {
        return regionRepository.findAll();
    }

    @Transactional
    public void create(RegionCreateDto regionCreateDto) {

        Region region = new Region(null,regionCreateDto.getCountry(),regionCreateDto.getName());
        regionRepository.save(region);
    }
    public Iterable<Region>saveAll(List<Region>regions){
        return regionRepository.saveAll(regions);
    }
    @Transactional
    public Region getById(Integer id){
        return regionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Region id" + id + "Not fount"));
    }
    @Transactional
    public void deleteById(Integer id) {
        regionRepository.deleteById(id);
    }

    @Transactional
    public void update(@ModelAttribute RegionUpdateDto regionUpdateDto, @NonNull Integer id) {
        Region region = regionRepository.findById(id).orElseThrow();
        region.setName(regionUpdateDto.getName());
        region.setCountry(regionUpdateDto.getCountry());
        regionRepository.save(region);

    }
}
