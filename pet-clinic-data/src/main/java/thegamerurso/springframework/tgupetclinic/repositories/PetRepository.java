package thegamerurso.springframework.tgupetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import thegamerurso.springframework.tgupetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet,Long>{

}
