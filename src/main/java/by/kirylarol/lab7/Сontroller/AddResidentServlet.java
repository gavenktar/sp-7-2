package by.kirylarol.lab7.Сontroller;


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

@WebServlet("/addresident")
public class AddResidentServlet  extends HttpServlet {

    ResidentService residentService = new ResidentService(new ResidentDaoImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("addresidentpage.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String language = req.getParameter("language");
        Resident resident = new Resident();
        resident.setLanguage(language);
        resident.setName(name);
        residentService.addResident(resident);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("main.jsp");
        requestDispatcher.forward(req,resp);
    }


}
