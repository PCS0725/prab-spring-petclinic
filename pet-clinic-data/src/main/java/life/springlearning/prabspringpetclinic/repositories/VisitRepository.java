package life.springlearning.prabspringpetclinic.repositories;

import life.springlearning.prabspringpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
