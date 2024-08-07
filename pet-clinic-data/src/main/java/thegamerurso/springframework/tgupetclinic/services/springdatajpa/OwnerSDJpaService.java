package thegamerurso.springframework.tgupetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import thegamerurso.springframework.tgupetclinic.model.Owner;
import thegamerurso.springframework.tgupetclinic.repositories.OwnerRepository;
import thegamerurso.springframework.tgupetclinic.repositories.PetTypeRepository;
import thegamerurso.springframework.tgupetclinic.services.OwnerService;
import thegamerurso.springframework.tgupetclinic.repositories.PetRepository;

@Service
@Profile("springdatajps")
public class OwnerSDJpaService implements OwnerService
{
    private final OwnerRepository ownerRepository;
    private final PetRepository PetRepository;
    private final PetTypeRepository petTypeRepository;
    
    public OwnerSDJpaService(OwnerRepository ownerRepository,
            PetRepository petRepository,
            PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        PetRepository = petRepository;
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
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
       return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
      ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
      ownerRepository.deleteById(id);
    }
}
