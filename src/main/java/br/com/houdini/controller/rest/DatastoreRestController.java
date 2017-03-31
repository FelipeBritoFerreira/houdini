package br.com.houdini.controller.rest;

import br.com.houdini.beans.Galeria;
import br.com.houdini.dao.GaleriaDatastoreDao;
import br.com.houdini.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

/**
 * Created by FBF0113 on 15/02/2017.
 */
@RestController
public class DatastoreRestController {


    @Autowired
    private GaleriaDatastoreDao galeriaDatastoreDao;


    /**
     *
     * @return
     */
    @RequestMapping(value = "/datastore_inserir", method = RequestMethod.GET)
    public String inserir() {
        galeriaDatastoreDao.exemploTransacao();
        return "ok";
    }



    /**
     *
     * @return
     */
    @RequestMapping(value = "/datastore_buscar", method = RequestMethod.GET)
    public String buscar() {
        galeriaDatastoreDao.exemploBuscar();
        return "ok";
    }





}
