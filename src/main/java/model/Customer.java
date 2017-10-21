package model;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "customers")
public class Customer extends Entity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "name")
    private String name;

    public Customer() {
    }

    public Customer(int id, String name) {
        super(id, name);
    }

}
