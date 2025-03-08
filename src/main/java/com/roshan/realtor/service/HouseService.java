package com.roshan.realtor.service;

import com.roshan.realtor.model.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.roshan.realtor.repository.BrokerRepository;
import com.roshan.realtor.repository.HouseRepository;

import java.util.List;
import java.util.UUID;

@Service
public class HouseService {

    @Autowired
    private HouseRepository houseRepository;

    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }

    public List<House> getAllHousesByRealtorId(String name) {
        return houseRepository.findAllByBrokerName(name);
    }
}
