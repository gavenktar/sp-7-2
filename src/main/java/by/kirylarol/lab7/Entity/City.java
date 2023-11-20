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


}
