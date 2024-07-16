package com.example.new_app.district;

import com.example.new_app.district.dto.DistrictCreateDto;
import com.example.new_app.district.entity.District;
import com.example.new_app.quarter.dto.QuarterCreateDto;
import com.example.new_app.quarter.entity.Quarter;
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
public class DistrictController {
    private final DistrictService districtService;
    @GetMapping("/show-districtCreate")
    public String showCreate(){
        return "create-district";
    }
    @GetMapping("/districts")
    public ModelAndView getAll(){
        List<District> districtList = districtService.getAllDistrict();
        return new ModelAndView("district-list","district",districtList);

    }
    @PostMapping("/districtCreate")
    public String create(@ModelAttribute DistrictCreateDto districtCreateDto){
        districtService.create(districtCreateDto);

        return "redirect:/districts";
    }
    @GetMapping("/showDistrictUpdate/{id}")
    public String showUpdateDistrict(@PathVariable("id") Integer id, Model model){
        District district = districtService.getById(id);
        model.addAttribute("district",district);
        return "update-district";
    }
    @RequestMapping("/districtDelete/{id}")
    public String deleteDistrict(@PathVariable("id") Integer id){
        districtService.deleteById(id);
        return "redirect:/districts";
    }
    @PostMapping("/updateDistrict/{id}")
    public String updateDistrict(@PathVariable("id") Integer id, @ModelAttribute DistrictCreateDto districtCreateDto, BindingResult result) {
        districtService.update(districtCreateDto, id);
        return "redirect:/districts";
    }
}
