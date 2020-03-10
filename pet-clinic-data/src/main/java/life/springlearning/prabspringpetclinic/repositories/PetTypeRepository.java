package life.springlearning.prabspringpetclinic.repositories;

import life.springlearning.prabspringpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
