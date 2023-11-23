package by.kirylarol.lab7.Service;

import by.kirylarol.lab7.Dao.CityDao;
import by.kirylarol.lab7.Entity.City;
import by.kirylarol.lab7.Entity.CityResident;

import java.util.List;

public class CityService {

    CityDao cityDao;

    public CityService(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    public boolean addCity(City city) {
        return cityDao.addCity(city);
    }

    public boolean deleteCity(int cityId) {
        return cityDao.deleteCity(cityId);
    }

    public boolean updateCity(City city) {
        return cityDao.updateCity(city);
    }

    public City getCityByID (int cityId) { return cityDao.getCityById(cityId); }

    public List<City> getAll(){
        return cityDao.getAllCities();
    }



}
