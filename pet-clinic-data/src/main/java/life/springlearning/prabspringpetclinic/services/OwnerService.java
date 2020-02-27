package life.springlearning.prabspringpetclinic.services;

import life.springlearning.prabspringpetclinic.model.Owner;

import java.util.Set;

/* Service layer for accessing the data using spring jpa
We could have directly implemented the classes, but to have liberty of chosing between different implementations
of the underlying databases, we are adding a service layer in between.
 */
public interface OwnerService {
    Owner findByLastName(String lastName);
    Owner findById(Long id);
    Set<Owner> findAll();
    Owner save(Owner owner);
}
