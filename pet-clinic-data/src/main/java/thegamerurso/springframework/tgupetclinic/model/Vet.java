package thegamerurso.springframework.tgupetclinic.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "vets")
public class Vet extends Person
{
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities",joinColumns = @JoinColumn(name = "vet_id"),
    inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> speciality = new HashSet<>();

    public Set<Speciality> getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Set<Speciality> speciality) {
        this.speciality = speciality;
    }
}
