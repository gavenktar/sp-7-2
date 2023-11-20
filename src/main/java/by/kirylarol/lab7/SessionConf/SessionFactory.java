package by.kirylarol.lab7.SessionConf;

import by.kirylarol.lab7.Entity.City;
import by.kirylarol.lab7.Entity.CityResident;
import by.kirylarol.lab7.Entity.Resident;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactory {
        private static SessionFactory sessionFactory;

        private SessionFactory() {}

        public static SessionFactory getSessionFactory() {
            if (sessionFactory == null) {
                synchronized (SessionFactory.class) {
                    if (sessionFactory != null) return sessionFactory;else {
                        try {
                            Configuration configuration = new Configuration().configure();
                            configuration.addAnnotatedClass(City.class);
                            configuration.addAnnotatedClass(CityResident.class);
                            configuration.addAnnotatedClass(Resident.class);
                            configuration.setProperty("hibernate.hbm2ddl.auto", "update");

                            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                            sessionFactory = (SessionFactory) configuration.buildSessionFactory(builder.build());

                        } catch (Exception e) {
                            System.out.println("Исключение!" + e);
                        }
                    }
                }
            }
            return sessionFactory;
        }
}
