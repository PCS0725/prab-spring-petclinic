package life.springlearning.prabspringpetclinic.services;

import life.springlearning.prabspringpetclinic.model.Owner;

/* Service layer for accessing the data using spring jpa
We could have directly implemented the classes, but to have liberty of chosing between different implementations
of the underlying databases, we are adding a service layer in between.
 */
public interface OwnerService extends CrudService{
    Owner findByLastName(String lastName);
}
