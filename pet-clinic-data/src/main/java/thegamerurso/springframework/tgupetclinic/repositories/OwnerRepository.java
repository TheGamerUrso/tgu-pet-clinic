package thegamerurso.springframework.tgupetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import thegamerurso.springframework.tgupetclinic.model.Owner;
import java.util.List;


public interface OwnerRepository extends CrudRepository<Owner,Long>
{
    Owner findByLastName(String lastName);
    
}
