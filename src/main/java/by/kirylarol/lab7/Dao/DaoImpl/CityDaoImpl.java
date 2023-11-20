package by.kirylarol.lab7.Dao.DaoImpl;

import by.kirylarol.lab7.Dao.CityDao;
import by.kirylarol.lab7.Entity.City;
import by.kirylarol.lab7.SessionConf.SessionFactoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CityDaoImpl implements CityDao {

    @Override
    public boolean addCity(City city) {
        Transaction transaction = null;
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(city);
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
    public boolean deleteCity(int cityId) {
        Transaction transaction = null;
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            City city = session.get(City.class, cityId);
            if (city != null) {
                session.remove(city);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCity(City city) {
        Transaction transaction = null;
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(city);
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

}
