package model;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "companies")
public class Company extends Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comp_id")
    private int id;

    @Column(name = "name")
    private String name;


    public Company() {
    }

    public Company(int id, String name) {
        super(id, name);
    }
}
