package com.example.demo.persistance;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "city", schema = "public")
public class City {
    @Id
    @ColumnDefault("nextval('city_id_city_seq')")
    @Column(name = "id_city", nullable = false)
    private Integer id;

    @Column(name = "zip_code", nullable = false, length = 10)
    private String zipCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}