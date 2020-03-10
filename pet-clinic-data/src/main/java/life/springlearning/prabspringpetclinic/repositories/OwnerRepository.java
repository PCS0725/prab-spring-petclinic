package life.springlearning.prabspringpetclinic.repositories;

import life.springlearning.prabspringpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    public Owner findByLastName(String lastName);
}
