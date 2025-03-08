package com.roshan.realtor.controller;

import com.roshan.realtor.dto.HouseDTO;
import com.roshan.realtor.model.House;
import com.roshan.realtor.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/realtors")
public class RealtorController {

    @Autowired
    HouseService houseService;

    @GetMapping("/houses")
    public ResponseEntity<List<House>> getAllHouses(@RequestBody HouseDTO houseDTO) {

        List<House> houses;

        houses = houseService.getAllHousesByRealtorId(houseDTO.getName());
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }
}
