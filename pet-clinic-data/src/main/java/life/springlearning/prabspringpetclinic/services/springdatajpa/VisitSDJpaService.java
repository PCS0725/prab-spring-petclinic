package life.springlearning.prabspringpetclinic.services.springdatajpa;

import life.springlearning.prabspringpetclinic.model.Visit;
import life.springlearning.prabspringpetclinic.repositories.VisitRepository;
import life.springlearning.prabspringpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {
    private final VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return null;
    }

    @Override
    public Visit findById(Long aLong) {
        Optional<Visit> visitOptional = visitRepository.findById(aLong);
        return visitOptional.isPresent()?visitOptional.get():null;
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }
}
