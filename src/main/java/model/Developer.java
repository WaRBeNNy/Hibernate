package model;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "developers")
public class Developer extends Entity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dev_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "project_id")
    private int project_id;

    @Column(name = "comp_id")
    private int company_id;

    @Column(name = "salary")
    private double salary;

    public Developer() {
    }

    public Developer(int id, String name, int project_id, int company_id, double salary) {
        super(id, name);
        this.project_id = project_id;
        this.company_id = company_id;
        this.salary = salary;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
