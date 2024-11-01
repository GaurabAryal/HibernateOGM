package com.example.entities;

import org.bson.types.ObjectId;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "test")
public class TestEntity {
    @Id
    @Column(name = "_id")
    private ObjectId id;
    @Basic
    @Column(name = "age")
    private Integer age;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "address")
    private List<Address> address;

    // getters and setters for address
    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestEntity that = (TestEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(age, that.age) && Objects.equals(email, that.email) && Objects.equals(name, that.name) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, email, name, phoneNumber);
    }
}
