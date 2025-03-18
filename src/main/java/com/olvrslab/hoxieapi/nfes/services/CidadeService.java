package com.olvrslab.hoxieapi.nfes.services;

import com.olvrslab.hoxieapi.nfes.dtos.CidadeDTO;
import com.olvrslab.hoxieapi.nfes.entities.City;
import com.olvrslab.hoxieapi.nfes.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    CidadeRepository cidadeRepository;

    public List<City> list() {
        return cidadeRepository.findAll();
    }

    public City create(CidadeDTO dto) {
        City city = City.builder()
                .name(dto.getName())
                .code(dto.getCode())
                .build();

        return cidadeRepository.save(city);
    }

    public City get(Integer id) {
        return cidadeRepository.findById(id).orElseThrow();
    }

    public City update(Integer id, CidadeDTO dto) {
        City city = City.builder()
                .id(id)
                .name(dto.getName())
                .code(dto.getCode())
                .build();

        return cidadeRepository.save(city);
    }

    public City delete(Integer id) {
        City city = get(id);

        cidadeRepository.delete(city);

        return city;
    }

}
