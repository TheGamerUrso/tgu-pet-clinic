package thegamerurso.springframework.tgupetclinic.services;
import thegamerurso.springframework.tgupetclinic.model.Owner;
import java.util.Set;

public interface OwnerService 
{
    Owner findByLastName(String lastName);
    Owner findById(Long Id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
