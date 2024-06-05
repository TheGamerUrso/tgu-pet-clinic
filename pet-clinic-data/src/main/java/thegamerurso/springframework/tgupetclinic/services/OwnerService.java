package thegamerurso.springframework.tgupetclinic.services;
import thegamerurso.springframework.tgupetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>
{
    Owner findByLastName(String lastName);
}
