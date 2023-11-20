package by.kirylarol.lab7.Dao;

import by.kirylarol.lab7.Entity.City;

import java.util.List;

public interface CityDao {

    boolean addCity (City city);
    boolean deleteCity (int cityId);
    boolean updateCity (City city);

    List<City> getAllCities ();

}
