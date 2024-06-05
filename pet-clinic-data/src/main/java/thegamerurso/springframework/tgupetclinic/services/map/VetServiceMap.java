package thegamerurso.springframework.tgupetclinic.services.map;

import java.util.Set;

import thegamerurso.springframework.tgupetclinic.model.Vet;
import thegamerurso.springframework.tgupetclinic.services.CrudService;

public class VetServiceMap extends AbstractMapService<Vet,Long> implements CrudService<Vet,Long> {

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
        return super.save(object.getId(), object);
    }

}
