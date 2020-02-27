package life.springlearning.prabspringpetclinic.services;

import life.springlearning.prabspringpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Set<Vet> findAll();
    Vet save(Vet vet);
}
