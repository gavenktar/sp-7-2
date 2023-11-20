package by.kirylarol.lab7.Dao;

import by.kirylarol.lab7.Entity.Resident;

public interface ResidentDao {

    boolean addResident (Resident resident);
    boolean deleteResident (int residentID);

    boolean updateResident (Resident resident);
}
