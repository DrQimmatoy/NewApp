package com.example.new_app.region;

import com.example.new_app.country.CountryService;
import com.example.new_app.country.dto.CountryCreateDto;
import com.example.new_app.country.entity.Country;
import com.example.new_app.region.dto.RegionCreateDto;
import com.example.new_app.region.dto.RegionUpdateDto;
import com.example.new_app.region.entity.Region;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class RegionController {
    private final RegionService regionService;
    @GetMapping("/show-regionCreate")
    public String showCreate(){
        return "create-region";
    }
    @GetMapping("/regions")
    public ModelAndView getAll(){
        List<Region> regionList = regionService.getAllRegion();
        return new ModelAndView("region-list","region",regionList);

    }
    @PostMapping("/regionCreate")
    public String createRegion(@ModelAttribute RegionCreateDto regionCreateDto){

        regionService.create(regionCreateDto);

        return "redirect:/regions";
    }
    @GetMapping("/regionUpdate/{id}")
    public String showUpdateRegion(@PathVariable("id") Integer id, Model model){
        Region region = regionService.getById(id);
        model.addAttribute("region",region);
        return "update-region";
    }
    @RequestMapping("/regionDelete/{id}")
    public String deleteRegion(@PathVariable("id") Integer id){
        regionService.deleteById(id);
        return "redirect:/regions";
    }
    @PostMapping("/update/{id}")
    public String updateRegion(@PathVariable("id") Integer id, @ModelAttribute RegionUpdateDto regionUpdateDto, BindingResult result) {
        regionService.update(regionUpdateDto, id);
        return "redirect:/regions";
    }
}
