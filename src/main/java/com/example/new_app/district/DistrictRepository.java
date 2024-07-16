package com.example.new_app.district;

import com.example.new_app.district.entity.District;
import com.example.new_app.region.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District,Integer> {

}
