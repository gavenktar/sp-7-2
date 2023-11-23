package by.kirylarol.lab7.Сontroller;

import by.kirylarol.lab7.Dao.DaoImpl.CityResidentDaoImpl;
import by.kirylarol.lab7.Entity.CityResident;
import by.kirylarol.lab7.Entity.Resident;
import by.kirylarol.lab7.Service.CityResidentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/findbylanguage")
public class FindByLanguageServlet extends HttpServlet {

    private final CityResidentService cityResidentService = new CityResidentService(new CityResidentDaoImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cityId = Integer.parseInt(req.getParameter("city"));
        String language = req.getParameter("language");
        List<Resident> cityResidents = cityResidentService.getAllResidentByCityAndLanguage(cityId, language);
        req.setAttribute("cityResidents",cityResidents);
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}