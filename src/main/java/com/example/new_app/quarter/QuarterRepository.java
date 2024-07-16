package com.example.new_app.quarter;

import com.example.new_app.quarter.entity.Quarter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuarterRepository extends JpaRepository<Quarter,Integer> {

}
