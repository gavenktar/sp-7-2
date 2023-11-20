package by.kirylarol.lab7.Dao;

import by.kirylarol.lab7.Entity.Resident;

public interface ResidentDao {

    boolean updateResident (Resident resident);
    boolean addResident (Resident resident);
    boolean deleteResident (int residentID);

}
