package model;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "skills")
public class Skill extends Entity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "skill_id")
    private int id;

    @Column(name = "skillname")
    private String name;

    @Column(name = "dev_id")
    private int developer_id;

    public Skill() {
    }

    public Skill(int id, String name, int developer_id) {
        super(id, name);
        this.developer_id = developer_id;
    }

    public int getDeveloper_id() {
        return developer_id;
    }

    public void setDeveloper_id(int developer_id) {
        this.developer_id = developer_id;
    }
}

