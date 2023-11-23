package by.kirylarol.lab7.Dao;

import by.kirylarol.lab7.Entity.Resident;

import java.util.List;

public interface ResidentDao {

    boolean updateResident (Resident resident);
    boolean addResident (Resident resident);
    boolean deleteResident (int residentID);

    List<Resident> getAllResidents();

    Resident getResidentByName(String strings);
}
