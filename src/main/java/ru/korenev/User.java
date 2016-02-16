package ru.korenev;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by k1per on 15.02.2016.
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;
    private Boolean isAdmin;
    private Timestamp createdDate;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Timestamp getDate() {
        return createdDate;
    }

    public void setDate(Timestamp date) {
        this.createdDate = date;
    }
}
