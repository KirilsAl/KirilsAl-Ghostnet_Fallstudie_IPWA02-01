package de.kirils.ghostnet.ghostnetfallstudie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import  jakarta.persistence.*;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Person")
public class Person {

    @Id
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "person_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "personRole",
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private PersonRole PersonRole;
    
    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(
            name = "PhoneNumber"
    )
    private String phone;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public PersonRole getpersonRole() {
        return PersonRole;
    }

    public void setpersonRole(PersonRole personRole) {
        this.PersonRole = personRole;
    }

    public Person(String name, String phone, PersonRole personRole) {
        this.name = name;
        this.phone = phone;
        this.PersonRole = personRole;
    }

    public Person() {

    }
}
