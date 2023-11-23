package by.kirylarol.lab7.Сontroller;

import by.kirylarol.lab7.Dao.DaoImpl.CityDaoImpl;
import by.kirylarol.lab7.Dao.DaoImpl.CityResidentDaoImpl;
import by.kirylarol.lab7.Dao.DaoImpl.ResidentDaoImpl;
import by.kirylarol.lab7.Entity.City;
import by.kirylarol.lab7.Entity.CityResident;
import by.kirylarol.lab7.Entity.Resident;
import by.kirylarol.lab7.Service.CityResidentService;
import by.kirylarol.lab7.Service.CityService;
import by.kirylarol.lab7.Service.ResidentService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.http.HttpRequest;

@WebServlet("/addcityresident")
public class AddCityResidentServlet extends HttpServlet {

    CityService cityService = new CityService(new CityDaoImpl());
    ResidentService residentService = new ResidentService(new ResidentDaoImpl());
    CityResidentService cityResidentService = new CityResidentService(new CityResidentDaoImpl());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int cityId = Integer.parseInt(req.getParameter("city"));
        Long population = Long.parseLong(req.getParameter("population"));
        String strings = req.getParameter("residents");
        Resident resident = residentService.getResidentByName(strings);
        City city = cityService.getCityByID(cityId);
        CityResident cityResident = new CityResident();
        cityResident.setResident(resident);
        cityResident.setPopulation(population);
        cityResident.setCity(city);
        residentService.addResident(resident);
        cityResidentService.addCityResident(cityResident);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("main.jsp");
        requestDispatcher.forward(req, resp);
    }
}
