package com.diginamic.BestiolesREST.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.diginamic.BestiolesREST.entity.Species;
import com.diginamic.BestiolesREST.repository.SpeciesRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class SpeciesService {
	
	@Autowired
	private SpeciesRepository speciesRepository;

	public Species create(@Valid Species speciesToCreate) {
		return this.speciesRepository.save(speciesToCreate);
	}
	
	public Species update(@Valid Species updatedSpecies) {
		return this.speciesRepository.save(updatedSpecies);
	}
	
	public Page<Species> findAll(Pageable pageable) {
		return this.speciesRepository.findAll(pageable);
	}
	
	public Species findById(Integer id) {
		return this.speciesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	public void deleteById(Integer id) {
		speciesRepository.deleteById(id);
	}
	
}
