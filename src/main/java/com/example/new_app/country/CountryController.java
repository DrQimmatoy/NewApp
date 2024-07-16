package com.example.new_app.country;

import com.example.new_app.country.dto.CountryCreateDto;
import com.example.new_app.country.entity.Country;
import com.example.new_app.district.dto.DistrictCreateDto;
import com.example.new_app.district.entity.District;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class CountryController {
    private final CountryService countryService;
    @GetMapping("/show-createCountry")
    public String showCreate(){
        return "create-country";
    }
    @GetMapping("/countries")
    public ModelAndView getAll(){
        List<Country> countryList = countryService.getAllCountry();
        return new ModelAndView("country-list","country",countryList);

    }
    @PostMapping("/createCountry")
    public String create(@ModelAttribute CountryCreateDto countryCreateDto){

        countryService.create(countryCreateDto);

        return "redirect:/countries";
    }
    @GetMapping("/showCountryUpdate/{id}")
    public String showUpdateCountry(@PathVariable("id") Integer id, Model model){
        Country country = countryService.getById(id);
        model.addAttribute("country",country);
        return "update-country";
    }
    @RequestMapping("/countryDelete/{id}")
    public String deleteCountry(@PathVariable("id") Integer id){
        countryService.deleteById(id);
        return "redirect:/countries";
    }
    @PostMapping("/updateCountry/{id}")
    public String updateCountry(@PathVariable("id") Integer id, @ModelAttribute CountryCreateDto countryCreateDto, BindingResult result) {
        countryService.update(countryCreateDto, id);
        return "redirect:/countries";
    }
}
