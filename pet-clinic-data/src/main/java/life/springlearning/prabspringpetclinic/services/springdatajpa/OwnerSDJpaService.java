package life.springlearning.prabspringpetclinic.services.springdatajpa;

import life.springlearning.prabspringpetclinic.model.Owner;
import life.springlearning.prabspringpetclinic.repositories.OwnerRepository;
import life.springlearning.prabspringpetclinic.repositories.PetRepository;
import life.springlearning.prabspringpetclinic.repositories.PetTypeRepository;
import life.springlearning.prabspringpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

//Here we will define all the service layer methods(OwnerService) by taking a
//relational database as persistence. We will use repositories provided by spring
//data JPA to get basic crud operations done.
@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }


    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        Optional<Owner> ownerOptional =  ownerRepository.findById(id);
       return ownerOptional.isPresent()?ownerOptional.get():null;
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }
}
