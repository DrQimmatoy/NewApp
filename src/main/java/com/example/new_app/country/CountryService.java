package com.example.new_app.country;

import com.example.new_app.country.dto.CountryCreateDto;
import com.example.new_app.country.entity.Country;
import com.example.new_app.district.dto.DistrictCreateDto;
import com.example.new_app.district.entity.District;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;
    @Transactional
    public List<Country> getAllCountry() {
        return countryRepository.findAll();
    }

    @Transactional
    public void create(CountryCreateDto countryCreateDto) {
        Country country = new Country(null,countryCreateDto.getName(),null);
        countryRepository.save(country);
    }
    @Transactional
    public Country getById(Integer id){
        return countryRepository.findById(id).orElseThrow();
    }
    @Transactional
    public void deleteById(Integer id) {
        countryRepository.deleteById(id);
    }

    @Transactional
    public void update(@ModelAttribute CountryCreateDto countryCreateDto, @NonNull Integer id) {
        Country country = countryRepository.findById(id).orElseThrow();
        country.setName(countryCreateDto.getName());

        countryRepository.save(country);

    }
}
