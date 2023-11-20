package by.kirylarol.lab7.Service;

import by.kirylarol.lab7.Dao.CityResidentDao;
import by.kirylarol.lab7.Entity.CityResident;
import by.kirylarol.lab7.Entity.Resident;

import java.math.BigDecimal;
import java.util.List;

public class CityResidentService {
    CityResidentDao cityResidentDao;

    public CityResidentService(CityResidentDao cityResidentDao) {
        this.cityResidentDao = cityResidentDao;
    }

    public boolean addCityResident (CityResident cityResident){
        return cityResidentDao.addCityResident(cityResident);
    }

    public CityResident getCityResidentById (int id){
        return cityResidentDao.getCityResidentById(id);
    }

    public boolean deleteCityResident (CityResident cityResident){
        return cityResidentDao.deleteCityResident(cityResident);
    };

    public List<CityResident> getAllCityResidentByCity(int cityId) {
        return cityResidentDao.getAllCityResidentByCity(cityId);
    }

    public List<CityResident> getAllCityResidentByResident(int residentId) {
        return cityResidentDao.getAllCityResidentByResident(residentId);
    }

    public List<Resident> getAllResidentByCityAndLanguage(int cityId, String language) {
        return cityResidentDao.getAllResidentByCityAndLanguage(cityId, language);
    }

    public List<CityResident> getAllCityByPopulation(BigDecimal population) {
        return cityResidentDao.getAllCityByPopulation(population);
    }

    public List<Resident> getOldestResidents() {
        return cityResidentDao.getOldestResidents();
    }
}
