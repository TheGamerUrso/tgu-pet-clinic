package thegamerurso.springframework.tgupetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import thegamerurso.springframework.tgupetclinic.model.PetType;
import thegamerurso.springframework.tgupetclinic.services.CrudService;

@Service
@Profile({"default","map"})
public interface PetTypeService extends CrudService<PetType,Long>
{

}

