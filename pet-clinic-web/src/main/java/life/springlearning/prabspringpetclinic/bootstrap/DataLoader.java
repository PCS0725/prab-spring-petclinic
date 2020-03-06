package life.springlearning.prabspringpetclinic.bootstrap;

import life.springlearning.prabspringpetclinic.model.*;
import life.springlearning.prabspringpetclinic.services.OwnerService;
import life.springlearning.prabspringpetclinic.services.PetTypeService;
import life.springlearning.prabspringpetclinic.services.SpecialityService;
import life.springlearning.prabspringpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//To load the data into the data source at run time
//We'll create dat(Objects of POJOs) and then to implement methods on the data source,
//we need objects of service layer classes
@Component
public class DataLoader  implements CommandLineRunner {
    //We'are declaring the interface only as dependency.
    //We can have multiple implementations underneath.
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }


    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Prabhat");
        owner1.setLastName("Sharma");
        owner1.setAddress("Kuswar");
        owner1.setCity("Hamirpur");
        owner1.setTelephone("1234");
        ownerService.save(owner1);

        Pet prabhatsPet = new Pet();
        prabhatsPet.setOwner(owner1);
        prabhatsPet.setPetType(savedDogPetType);
        prabhatsPet.setBirthDate(LocalDate.now());
        prabhatsPet.setName("Tommy");
        owner1.getPets().add(prabhatsPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Anjali");
        owner2.setLastName("Shukla");
        owner2.setAddress("MMV");
        owner2.setCity("Banaras");
        owner2.setTelephone("1234");
        ownerService.save(owner2);

        Pet anjalisPet = new Pet();
        anjalisPet.setOwner(owner2);
        anjalisPet.setPetType(savedDogPetType);
        anjalisPet.setBirthDate(LocalDate.now());
        anjalisPet.setName("Billy");
        owner2.getPets().add(anjalisPet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Vikas");
        vet1.setLastName("Pandey");
        vetService.save(vet1);
        vet1.getSpecialities().add(savedSurgery);

        Vet vet2 = new Vet();
        vet2.setFirstName("Akshita");
        vet2.setLastName("Sharma");
        vetService.save(vet2);
        vet2.getSpecialities().add(savedRadiology);

        System.out.println("Loading Data..");
    }
}
