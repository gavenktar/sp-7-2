package by.kirylarol.lab7.Service;

import by.kirylarol.lab7.Dao.ResidentDao;
import by.kirylarol.lab7.Entity.Resident;

import java.util.List;

public class ResidentService {
    ResidentDao residentDao;


    public List<Resident> getALlResidents (){ return this.residentDao.getAllResidents(); }

    public ResidentService(ResidentDao residentDao) {
        this.residentDao = residentDao;
    }

    public boolean updateResident(Resident resident) {
        return residentDao.updateResident(resident);
    }

    public boolean addResident(Resident resident) {
        return residentDao.addResident(resident);
    }

    public boolean deleteResident(int residentID) {
        return residentDao.deleteResident(residentID);
    }

    public Resident getResidentByName(String strings) {
        return residentDao.getResidentByName (strings);
    }
}
