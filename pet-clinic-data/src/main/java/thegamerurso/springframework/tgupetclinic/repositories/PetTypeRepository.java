package thegamerurso.springframework.tgupetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import thegamerurso.springframework.tgupetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {

}
