package thegamerurso.springframework.tgupetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import thegamerurso.springframework.tgupetclinic.model.Speciality;
import thegamerurso.springframework.tgupetclinic.model.Vet;
import thegamerurso.springframework.tgupetclinic.services.SpecialityService;
import thegamerurso.springframework.tgupetclinic.services.VetService;

@Service
@Profile({"default","map"})
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialityService specialitesService;

    
    public VetMapService(SpecialityService specialitesService) {
        this.specialitesService = specialitesService;
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpeciality().size() > 0)
        {
            object.getSpeciality().forEach(speciality ->{
                if(speciality.getId() == null){
                    Speciality savedSpeciality = specialitesService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

}
