package thegamerurso.springframework.tgupetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import thegamerurso.springframework.tgupetclinic.model.Owner;
import thegamerurso.springframework.tgupetclinic.model.Pet;
import thegamerurso.springframework.tgupetclinic.model.PetType;
import thegamerurso.springframework.tgupetclinic.model.Speciality;
import thegamerurso.springframework.tgupetclinic.model.Vet;
import thegamerurso.springframework.tgupetclinic.model.Visit;
import thegamerurso.springframework.tgupetclinic.services.OwnerService;
import thegamerurso.springframework.tgupetclinic.services.SpecialityService;
import thegamerurso.springframework.tgupetclinic.services.VetService;
import thegamerurso.springframework.tgupetclinic.services.VisitService;
import thegamerurso.springframework.tgupetclinic.services.map.PetTypeService;

@Component
public class DataLoader implements CommandLineRunner
{
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialitesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
            SpecialityService specialitesService,VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitesService = specialitesService;
        this.visitService = visitService;
    }


    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count==0)
            loadData();
    }


    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialitesService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialitesService.save(surgery);
        
        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialitesService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231234");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Gienanne");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231234");


        Pet fiona = new Pet();
        fiona.setName("Just Cat");
        fiona.setPetType(savedCatPetType);
        fiona.setOwner(owner2);
        fiona.setBirthDate(LocalDate.now());
        owner2.getPets().add(fiona);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fiona);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        visitService.save(catVisit);

        System.out.println("Loaded Owners...");
        
        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpeciality().add(savedRadiology);
        vetService.save(vet1);
        
        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpeciality().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
    

}
