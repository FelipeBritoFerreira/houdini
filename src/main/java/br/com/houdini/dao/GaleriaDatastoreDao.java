package br.com.houdini.dao;

import com.google.appengine.api.datastore.*;
import org.springframework.stereotype.Component;

/**
 * Created by FBF0113 on 16/02/2017.
 */
@Component
public class GaleriaDatastoreDao {



    public void exemploTransacao() {

        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        Transaction transaction = datastoreService.beginTransaction();

        try {

            Entity entity = new Entity("Galeria", 1);
            entity.setProperty("nome","mano a mano");
            entity.setProperty("titulo_thumbnail","Mano a Mano");
            entity.setProperty("titulo_modal","Mano a Mano");
            entity.setProperty("desafio","Ativar a praia de Copacana para o desafio de atletismo com Usain Bolt.");

            datastoreService.put(entity);

            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }


    }


    public void exemploBuscar() {

        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

        Query query = new Query("Galeria").setFilter( new  Query.FilterPredicate("nome", Query.FilterOperator.EQUAL, "mano a mano")   );

        PreparedQuery preparedQuery = datastoreService.prepare(query);


        StringBuilder textos = new StringBuilder();

        for (Entity galeria : preparedQuery.asIterable()) {
            textos.append(( String) galeria.getProperty("desafio") );
            textos.append(( String) galeria.getProperty("titulo_thumbnail") );
        }

        System.out.println(textos);


    }









}
