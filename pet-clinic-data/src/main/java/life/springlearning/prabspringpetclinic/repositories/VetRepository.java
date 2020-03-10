package life.springlearning.prabspringpetclinic.repositories;

import life.springlearning.prabspringpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
