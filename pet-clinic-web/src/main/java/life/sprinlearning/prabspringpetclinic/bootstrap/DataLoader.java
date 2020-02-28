package life.sprinlearning.prabspringpetclinic.bootstrap;

import life.springlearning.prabspringpetclinic.model.Owner;
import life.springlearning.prabspringpetclinic.model.Vet;
import life.springlearning.prabspringpetclinic.services.OwnerService;
import life.springlearning.prabspringpetclinic.services.VetService;
import life.springlearning.prabspringpetclinic.services.map.OwnerServiceMap;
import life.springlearning.prabspringpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
//To load the data into the data source at run time
//We'll create dat(Objects of POJOs) and then to implement methods on the data source,
//we need objects of service layer classes
@Component
public class DataLoader  implements CommandLineRunner {
    //We'are declaring the interface only as dependency.
    //We can have multiple implementations underneath.
    private final OwnerService ownerService;
    private final VetService vetService;

    //will configure later for spring to autoinject the dependency.
    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Prabhat");
        owner1.setLastName("Sharma");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Anjali");
        owner2.setLastName("Shukla");
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Vikas");
        vet1.setLastName("Pandey");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Akshita");
        vet2.setLastName("Sharma");
        vetService.save(vet2);

        System.out.println("Loading Data..");

    }
}
