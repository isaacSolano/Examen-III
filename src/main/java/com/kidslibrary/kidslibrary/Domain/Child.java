package com.kidslibrary.kidslibrary.Domain;

import javax.persistence.*;

@Entity
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private boolean readingMember;
    private boolean daycareMember;
    private String alergies;


    public Child(Long id, String name, boolean isReadingMember, boolean daycareMember, String alergies) {
        this.id = id;
        this.name = name;
        this.readingMember = isReadingMember;
        this.daycareMember = daycareMember;
        this.alergies = alergies;
    }

    public Child() {
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

    public boolean isReadingMember() {
        return readingMember;
    }

    public void setReadingMember(boolean readingMember) {
        this.readingMember = readingMember;
    }

    public boolean isDaycareMember() {
        return daycareMember;
    }

    public void setDaycareMember(boolean daycareMember) {
        this.daycareMember = daycareMember;
    }

    public String getAlergies() {
        return alergies;
    }

    public void setAlergies(String alergies) {
        this.alergies = alergies;
    }
}
