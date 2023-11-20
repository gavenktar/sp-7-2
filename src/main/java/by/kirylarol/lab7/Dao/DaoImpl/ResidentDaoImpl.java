package by.kirylarol.lab7.Dao.DaoImpl;

import by.kirylarol.lab7.Dao.ResidentDao;
import by.kirylarol.lab7.Entity.Resident;
import by.kirylarol.lab7.SessionConf.SessionFactoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ResidentDaoImpl implements ResidentDao {
    @Override
    public boolean updateResident(Resident resident) {
        Transaction transaction = null;
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(resident);
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
    public boolean addResident(Resident resident) {
        Transaction transaction = null;
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(resident);
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
    public boolean deleteResident(int residentID) {
        Transaction transaction = null;
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Resident resident = session.get(Resident.class, residentID);
            if (resident != null) {
                session.remove(resident);
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

}
