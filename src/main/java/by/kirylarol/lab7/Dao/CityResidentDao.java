package by.kirylarol.lab7.Dao;

import by.kirylarol.lab7.Entity.City;
import by.kirylarol.lab7.Entity.CityResident;
import by.kirylarol.lab7.Entity.Resident;

import java.math.BigDecimal;
import java.util.List;

public interface CityResidentDao {

    boolean addCityResident (CityResident cityResident);

    CityResident getCityResidentById (int id);

    boolean deleteCityResident (CityResident cityResident);

    List<CityResident> getAllCityResidentByCity (int cityId);
    List<CityResident> getAllCityResidentByResident (int residentId);

    List<Resident> getAllResidentByCityAndLanguage (int cityId, String language);

    List<City> getAllCityByPopulation (Long population);

    List<Resident> getOldestResidents ();
}
