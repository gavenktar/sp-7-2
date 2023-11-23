package by.kirylarol.lab7.Сontroller;

import by.kirylarol.lab7.Dao.CityResidentDao;
import by.kirylarol.lab7.Dao.DaoImpl.CityResidentDaoImpl;
import by.kirylarol.lab7.Dao.DaoImpl.ResidentDaoImpl;
import by.kirylarol.lab7.Entity.City;
import by.kirylarol.lab7.Entity.CityResident;
import by.kirylarol.lab7.Entity.Resident;
import by.kirylarol.lab7.Service.CityResidentService;
import by.kirylarol.lab7.Service.ResidentService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;


@WebServlet("/finbypopulation")
public class FindByPopulationServlet extends HttpServlet {

    CityResidentService cityResidentService = new CityResidentService(new CityResidentDaoImpl());
    ResidentService residentService = new ResidentService(new ResidentDaoImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long population =Long.parseLong(req.getParameter("population"));
        City city = cityResidentService.getAllCityByPopulation(population).get(0);
        req.setAttribute("City", city);
        List<Resident> residentList = residentService.getALlResidents();
        req.setAttribute("ResidentList", residentList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("citypage.jsp");
        requestDispatcher.forward(req,resp);
    }
}
