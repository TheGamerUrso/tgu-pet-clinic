package thegamerurso.springframework.tgupetclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity
{
    
    public Person(Long Id,String firstName, String lastName) {
        super(Id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Column(name= "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    
}
