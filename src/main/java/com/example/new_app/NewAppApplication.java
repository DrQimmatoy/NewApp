package com.example.new_app;

import com.example.new_app.district.DistrictService;
import com.example.new_app.district.entity.District;
import com.example.new_app.region.RegionService;
import com.example.new_app.region.entity.Region;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class NewAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewAppApplication.class, args);
	}
	@Bean
	CommandLineRunner runnerRegion(RegionService regionService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Region>> typeReference = new TypeReference<List<Region>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/regions.json");
			try {
				List<Region> regions = mapper.readValue(inputStream,typeReference);
				regionService.saveAll(regions);
				System.out.println("Regions Saved!");
			} catch (IOException e){
				System.out.println("Unable to save regions: " + e.getMessage());
			}
		};
	}
	@Bean
	CommandLineRunner runnerDistrict(DistrictService districtService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<District>> typeReference = new TypeReference<List<District>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/districts.json");
			try {
				List<District> districts = mapper.readValue(inputStream,typeReference);
				districtService.saveAll(districts);
				System.out.println("Districts Saved!");
			} catch (IOException e){
				System.out.println("Unable to save districts: " + e.getMessage());
			}
		};
	}


}
