package thegamerurso.springframework.tgupetclinic.services;
import thegamerurso.springframework.tgupetclinic.model.Vet;
import java.util.Set;0

public interface VetService {
    Vet findById(Long Id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
