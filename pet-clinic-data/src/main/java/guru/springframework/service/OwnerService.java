package guru.springframework.service;

import java.util.Set;

import guru.springframework.model.Owner;

public interface OwnerService {
	
	Owner findByLastName(String lastName);
	
	Owner findById(long id);
	
	Owner save(Owner owner);
	
	Set<Owner> findAll();
}
