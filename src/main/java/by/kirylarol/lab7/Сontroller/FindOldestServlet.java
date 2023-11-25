package by.kirylarol.lab7.Сontroller;

import by.kirylarol.lab7.Dao.DaoImpl.CityResidentDaoImpl;
import by.kirylarol.lab7.Entity.Resident;
import by.kirylarol.lab7.Service.CityResidentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/oldest")
public class FindOldestServlet extends HttpServlet {

    private CityResidentService cityResidentService = new CityResidentService(new CityResidentDaoImpl());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Resident> residentList = cityResidentService.getOldestResidents();

        req.setAttribute("cityResidents",residentList);
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}
