package org.zeroxthree;

import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;


    public static SessionFactory getSessionFactory(){
        //singleton - если объекта нет - создаем, если есть - возвращаем

        if(sessionFactory == null){
                try{
                    //стандартные действия для хибернейт проекта
                    //по сути это конф файл

                Map<String, String> settings = new HashMap<>();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/zeroxthree");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "admin");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL10Dialect");
                settings.put(Environment.GENERATE_STATISTICS, "false");

                //settings.put(Environment.FORMAT_SQL, "true");

                StandardServiceRegistryBuilder registryBuilder =
                        new StandardServiceRegistryBuilder().applySettings(settings);

                registry = registryBuilder.build();

                MetadataSources sources = new MetadataSources(registry);
                sources.addAnnotatedClass(Players.class);

                Metadata metadata = sources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();

                }catch (Exception e){
                    e.printStackTrace();
                    if(registry != null){
                        StandardServiceRegistryBuilder.destroy(registry);
                    }
                }

        }
        return sessionFactory;
    }

    public static void close(){
        if(registry != null){
            StandardServiceRegistryBuilder.destroy(registry);
        }

    }
}
