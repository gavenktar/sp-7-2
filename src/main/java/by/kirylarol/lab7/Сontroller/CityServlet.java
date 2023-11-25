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
import java.util.List;


@WebServlet("/city")
public class CityServlet extends HttpServlet {

    private CityService cityService = new CityService(new CityDaoImpl());
    private  ResidentService residentService = new ResidentService(new ResidentDaoImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int id = Integer.parseInt(req.getParameter("id"));
        City city = cityService.getCityByID(id);
        List<Resident> residentList = residentService.getALlResidents();
        req.setAttribute("City", city);
        req.setAttribute("ResidentList",residentList);
        RequestDispatcher requestDispatcher =  req.getRequestDispatcher("citypage.jsp");
        requestDispatcher.forward(req,resp);

    }
}
