package entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Created by iranna on 13-7-16.
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "auto_gen")
    @SequenceGenerator(name = "auto_gen", sequenceName = "id_seq")
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
