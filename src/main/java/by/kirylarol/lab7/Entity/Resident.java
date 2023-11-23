package by.kirylarol.lab7.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="residents")
public class Resident {

    @Id
    @GeneratedValue (strategy =  GenerationType.AUTO)
    @Column(name = "resident_id")
    private int residentID;

    @Column
    private String name;

    @Column
    private String language;

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
}
