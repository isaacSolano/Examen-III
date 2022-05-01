package com.kidslibrary.kidslibrary.Domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Parent {
    @Id
    private Long id;
    private String name;
    private String address;
    private String primaryPhone;
    private String secondaryPhone;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Child> childs;

    public Parent(Long id, String name, String address, String primaryPhone, String secondaryPhone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.primaryPhone = primaryPhone;
        this.secondaryPhone = secondaryPhone;
    }

    public Parent() {

    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    public Set<Child> getChilds() {
        return childs;
    }

    public void setChilds(Set<Child> childs) {
        this.childs = childs;
    }
}
