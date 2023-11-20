package by.kirylarol.lab7.Entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "cities")
public class City {
    @Id
    @GeneratedValue (strategy =  GenerationType.AUTO)
    @Column (name = "city_id")
    private int cityID;


    @Column (name = "foundation_year")
    private int foundationYear;

    @Column (name = "square")
    private double square;


    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    List<CityResident> cityResidentList;


    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(int foundationYear) {
        this.foundationYear = foundationYear;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public List<CityResident> getCityResidentList() {
        return cityResidentList;
    }

    public void setCityResidentList(List<CityResident> cityResidentList) {
        this.cityResidentList = cityResidentList;
    }
}
