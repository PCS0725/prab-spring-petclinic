package life.springlearning.prabspringpetclinic.repositories;

import life.springlearning.prabspringpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
