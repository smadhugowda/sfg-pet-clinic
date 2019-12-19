package guru.springframework.service;

import java.util.Set;

import guru.springframework.model.Pet;

public interface PetService {
	
	Pet findById(long id);
	
	Pet save(Pet pet);
	
	Set<Pet> findAll();
}
