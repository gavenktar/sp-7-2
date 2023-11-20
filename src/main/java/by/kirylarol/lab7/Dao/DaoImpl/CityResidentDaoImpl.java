package by.kirylarol.lab7.Dao.DaoImpl;

import by.kirylarol.lab7.Dao.CityResidentDao;
import by.kirylarol.lab7.Entity.CityResident;
import by.kirylarol.lab7.Entity.Resident;
import by.kirylarol.lab7.SessionConf.SessionFactoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class CityResidentDaoImpl implements CityResidentDao {
    @Override
    public boolean addCityResident(CityResident cityResident) {
        Transaction transaction = null;
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(cityResident);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public CityResident getCityResidentById(int id) {
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            return session.get(CityResident.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteCityResident(CityResident cityResident) {
        Transaction transaction = null;
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(cityResident);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<CityResident> getAllCityResidentByCity(int cityId) {
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            Query<CityResident> query = session.createQuery("FROM CityResident WHERE city.cityID = :cityId", CityResident.class);
            query.setParameter("cityId", cityId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<CityResident> getAllCityResidentByResident(int residentId) {
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            Query<CityResident> query = session.createQuery("FROM CityResident WHERE resident.residentID = :residentId", CityResident.class);
            query.setParameter("residentId", residentId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Resident> getAllResidentByCityAndLanguage(int cityId, String language) {
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            Query<Resident> query = session.createQuery(
                    "SELECT cr.resident FROM CityResident cr JOIN cr.city c WHERE c.cityID = :cityId AND cr.resident.language = :language",
                    Resident.class
            );
            query.setParameter("cityId", cityId);
            query.setParameter("language", language);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<CityResident> getAllCityByPopulation(BigDecimal population) {
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            Query<CityResident> query = session.createQuery("FROM CityResident cr JOIN cr.city c WHERE cr.population = :population", CityResident.class);
            query.setParameter("population", population);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Resident> getOldestResidents() {
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            Query<Resident> query = session.createQuery("SELECT cr.resident FROM CityResident cr" +
                    " WHERE cr.city.foundationYear = (SELECT MIN(c.foundationYear) FROM City c)", Resident.class);
            query.setMaxResults(10);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
