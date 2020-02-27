package life.springlearning.prabspringpetclinic.services;

import life.springlearning.prabspringpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Set<Pet> findAll();
    Pet save(Pet pet);
}
