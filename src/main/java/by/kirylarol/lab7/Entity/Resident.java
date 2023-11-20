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


}
