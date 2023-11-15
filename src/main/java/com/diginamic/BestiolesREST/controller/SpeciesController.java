package com.diginamic.BestiolesREST.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginamic.BestiolesREST.entity.Species;
import com.diginamic.BestiolesREST.service.SpeciesService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/rest/species")
public class SpeciesController {

	@Autowired
	private SpeciesService speciesService;
	
	@PostMapping
	public Species createSpecies(@RequestBody @Valid Species speciesToCreate) {
		return speciesService.create(speciesToCreate);
	}
	
	@PutMapping
	public Species updateSpecies(@RequestBody @Valid Species updatedSpecies) {
		return speciesService.update(updatedSpecies);
	}
	
	@GetMapping("/page")
	public Page<Species> findPage(@PathParam("pageable") Pageable pageable) {
		return speciesService.findPage(pageable);
	}
	
	@GetMapping("/all")
	public List<Species> findAll() {
		return speciesService.findAll();
	}
	
	@GetMapping("/{id}")
	public Species findOne(@PathVariable("id") Integer id) {
		return speciesService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOne(@PathVariable("id") Integer id) {
		speciesService.deleteById(id);
	}
	
}
