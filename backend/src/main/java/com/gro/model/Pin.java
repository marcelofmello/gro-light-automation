package com.gro.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gro.model.sensor.Sensor;


@Entity
@Table(name = "pin")
public class Pin {

    @Id
    private int id;

    @NotNull
    private String alias;

    @OneToOne(mappedBy = "pin", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private Sensor sensor;

    public Pin() { }
    
    public Pin(String alias) {
        this.alias = alias;
    }

    public Pin(int id, String alias) {
        this.id = id;
        this.alias = alias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

}