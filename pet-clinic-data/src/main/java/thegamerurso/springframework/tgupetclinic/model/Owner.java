package thegamerurso.springframework.tgupetclinic.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@Entity
@Table(name = "owners")
public class Owner extends Person
{
    @Builder
    public Owner(Long Id,String firstName,String lastName,String address, String city,
     String telephone, Set<Pet> pets) {
        super(Id,firstName,lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    @Column(name = "address")
    private String address;
    
    @Column(name ="city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public Set<Pet> getPets() {
        return pets;
    }
    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
    
}
