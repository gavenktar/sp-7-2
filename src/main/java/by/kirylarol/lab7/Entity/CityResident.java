package by.kirylarol.lab7.Entity;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Table(name = "city_to_resident")
@Entity
public class CityResident {

    @Id
    private int cityResidentId;
    @ManyToOne
    @JoinColumn (name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn (name = "resident_id")
    private Resident resident;

    private BigDecimal population;


    public int getCityResidentId() {
        return cityResidentId;
    }

    public void setCityResidentId(int cityResidentId) {
        this.cityResidentId = cityResidentId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public BigDecimal getPopulation() {
        return population;
    }

    public void setPopulation(BigDecimal population) {
        this.population = population;
    }
}
