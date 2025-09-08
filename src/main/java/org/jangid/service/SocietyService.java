package org.jangid.service;


import lombok.RequiredArgsConstructor;
import org.jangid.model.House;
import org.jangid.model.Resident;
import org.jangid.model.Society;
import org.jangid.repository.HouseRepository;
import org.jangid.repository.ResidentRepository;
import org.jangid.repository.SocietyRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor()
public class SocietyService {

    private final SocietyRepository societyRepository;
    private final HouseRepository houseRepository;
    private final ResidentRepository residentRepository;

    public Society addSociety(String name) {
        Society society = new Society(name);
        return societyRepository.save(society);
    }

    public void addHouseInSociety(int societyId) {
        Society society = societyRepository.findById(societyId).orElseThrow(() -> new NoSuchElementException("Society not found"));
        House house = new House(societyId);
        houseRepository.save(house);
        society.getHouseList().add(house);
        societyRepository.save(society);
    }

    public void addResidentInHouse(int houseId, String residentName) {
        House house = houseRepository.findById(houseId).orElseThrow(() -> new NoSuchElementException("House not found"));
        Resident resident = new Resident(residentName, houseId, house.getSocietyId());
        residentRepository.save(resident);
        house.getResidentList().add(resident);
        houseRepository.save(house);
    }



}
