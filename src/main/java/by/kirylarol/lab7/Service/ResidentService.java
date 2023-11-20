package by.kirylarol.lab7.Service;

import by.kirylarol.lab7.Dao.ResidentDao;
import by.kirylarol.lab7.Entity.Resident;

public class ResidentService {
    ResidentDao residentDao;



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
}
