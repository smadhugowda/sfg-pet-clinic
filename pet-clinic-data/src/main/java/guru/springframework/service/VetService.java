package guru.springframework.service;

import java.util.Set;

import guru.springframework.model.Vet;

public interface VetService {
	
	Vet findById(long id);
	
	Vet save(Vet pet);
	
	Set<Vet> findAll();
}
