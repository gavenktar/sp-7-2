package by.kirylarol.lab7.Сontroller;

import by.kirylarol.lab7.Dao.DaoImpl.CityDaoImpl;
import by.kirylarol.lab7.Entity.City;
import by.kirylarol.lab7.Service.CityService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;


@WebServlet ("/mainpage")
public class MainPageServlet extends HttpServlet {

    private CityService cityService = new CityService(new CityDaoImpl());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<City> cityList = cityService.getAll();
        req.setAttribute("cities",cityList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("main.jsp");
        requestDispatcher.forward(req,resp);
    }
}
