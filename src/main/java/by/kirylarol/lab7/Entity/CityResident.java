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


}
