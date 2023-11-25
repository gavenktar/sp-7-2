package by.kirylarol.lab7.Сontroller;

import by.kirylarol.lab7.Dao.CityResidentDao;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
@WebServlet("/newcity")
public class NewCityServlet extends HttpServlet {

    private CityResidentService cityResidentService = new CityResidentService(new CityResidentDaoImpl());
    private ResidentService residentService = new ResidentService(new ResidentDaoImpl());
    private CityService cityService = new CityService(new CityDaoImpl());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Resident> residentList = residentService.getALlResidents();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("addcitypage.jsp");
        req.setAttribute("ResidentList",residentList);
        requestDispatcher.forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        String title = req.getParameter("cityTitle");
        int year = Integer.parseInt(req.getParameter("date"));
        double square = Double.parseDouble(req.getParameter("square"));
        Long population = Long.parseLong(req.getParameter("population"));
        String strings = req.getParameter("residents");
        Resident resident = residentService.getResidentByName(strings);
        CityResident cityResident = new CityResident();
        cityResident.setResident(resident);
        cityResident.setPopulation(population);
        City city = new City();
        city.setName(title);
        city.setSquare(square);
        city.setFoundationYear(year);
        cityResident.setCity(city);
        cityService.addCity(city);
        cityResidentService.addCityResident(cityResident);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("main.jsp");
        requestDispatcher.forward(req,resp);
    }
}

