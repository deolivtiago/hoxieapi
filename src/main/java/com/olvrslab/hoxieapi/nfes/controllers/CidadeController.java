package com.olvrslab.hoxieapi.nfes.controllers;

import com.olvrslab.hoxieapi.nfes.dtos.CidadeDTO;
import com.olvrslab.hoxieapi.nfes.entities.City;
import com.olvrslab.hoxieapi.nfes.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CidadeController {
    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public ResponseEntity<List<City>> list() {
        return ResponseEntity.ok(cidadeService.list());
    }

    @PostMapping
    public ResponseEntity<City> create(@RequestBody CidadeDTO dto) {
        City city = cidadeService.create(dto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(city.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> get(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(cidadeService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> update(@PathVariable("id") Integer id, @RequestBody CidadeDTO dto) {
        cidadeService.update(id, dto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> delete(@PathVariable("id") Integer id) {
        cidadeService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
