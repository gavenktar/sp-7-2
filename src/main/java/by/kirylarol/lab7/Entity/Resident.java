package by.kirylarol.lab7.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="residents")
public class Resident {
    @Id
    @Column(name = "resident_id")
    private int residentID;

    @Column
    private String name;

    @Column
    private String language;

    @OneToMany(mappedBy = "resident", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    public List<CityResident> cityResidentList;

    public int getResidentID() {
        return residentID;
    }

    public void setResidentID(int residentID) {
        this.residentID = residentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<CityResident> getCityResidentList() {
        return cityResidentList;
    }

    public void setCityResidentList(List<CityResident> cityResidentList) {
        this.cityResidentList = cityResidentList;
    }
}
