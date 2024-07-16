package com.example.new_app.quarter;

import com.example.new_app.district.dto.DistrictCreateDto;
import com.example.new_app.district.entity.District;
import com.example.new_app.quarter.dto.QuarterCreateDto;
import com.example.new_app.quarter.entity.Quarter;
import com.example.new_app.region.dto.RegionUpdateDto;
import com.example.new_app.region.entity.Region;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class QuarterController {
    private final QuarterService quarterService;

    @GetMapping("/show-quarterCreate")
    public String showCreate(){
        return "create-quarter";
    }
    @GetMapping("/quarters")
    public ModelAndView getAll(){
        List<Quarter> quarterList = quarterService.getAllQuarter();
        return new ModelAndView("quarter-list","quarter",quarterList);

    }
    @PostMapping("/quarterCreate")
    public String create(@ModelAttribute QuarterCreateDto quarterCreateDto){
        quarterService.create(quarterCreateDto);

        return "redirect:/quarters";
    }
    @GetMapping("/showQuarterUpdate/{id}")
    public String showUpdateQuarter(@PathVariable("id") Integer id, Model model){
        Quarter quarter = quarterService.getById(id);
        model.addAttribute("quarter",quarter);
        return "update-quarter";
    }
    @RequestMapping("/quarterDelete/{id}")
    public String deleteQuarter(@PathVariable("id") Integer id){
        quarterService.deleteById(id);
        return "redirect:/quarters";
    }
    @PostMapping("/updateQuarter/{id}")
    public String updateQuarter(@PathVariable("id") Integer id, @ModelAttribute QuarterCreateDto quarterCreateDto, BindingResult result) {
        quarterService.update(quarterCreateDto, id);
        return "redirect:/quarters";
    }
}
