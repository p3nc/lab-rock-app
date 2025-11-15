package com.rockmusic.lab4_rock.models;
import jakarta.persistence.*;

@Entity
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String originCountry;
    private int yearFormed;


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

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public int getYearFormed() {
        return yearFormed;
    }

    public void setYearFormed(int yearFormed) {
        this.yearFormed = yearFormed;
    }
}