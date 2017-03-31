package br.com.houdini.controller.rest;

import br.com.houdini.beans.Galeria;
import br.com.houdini.service.GaleriaStorageService;
import br.com.houdini.utils.HtmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FBF0113 on 15/02/2017.
 */
@RestController
@RequestMapping(value = "galeria")
@CrossOrigin
public class GaleriaImagensRestController {


    @Autowired
    private GaleriaStorageService galeriaStorageService;

    @Autowired
    private HtmlUtils htmlUtils;

    private List<Galeria> galerias;


    public GaleriaImagensRestController() {
        try {
           galerias = galeriaStorageService.listarGalerias();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     *  Retorna o url de um thumbnail de uma determinada galeria
     *
     * @return
     */
    @RequestMapping(value = "buscarURLThumbnail", method = RequestMethod.GET)
    public String downloadImagem(@RequestParam(value = "nomeGaleria") String nomeGaleria) {

        String urlImagem = new String();

        try {
            urlImagem = galeriaStorageService.buscarUrlImagem("galeria/"+nomeGaleria+"/capa.jpg");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return urlImagem;
    }



    /**
     * Lista a url de todas as imagens de uma determinada galeria
     *
     * @return
     */
    @RequestMapping(value = "listarImagens", method = RequestMethod.GET)
    public Galeria listarImagens(@RequestParam(value = "nomeGaleria") String nomeGaleria) {

        List<String> objectList = new ArrayList<>();

        Galeria galeria = new Galeria();
        galeria.setNomeGaleria(nomeGaleria);

        try {
            galeria = galeriaStorageService.listarImagensGaleria(galeria);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return galeria;
    }

    /**
     * Lista o nome de todas as galerias que existem no storage
     *
     * @return
     */
    @RequestMapping(value = "listarNomes", method = RequestMethod.GET)
    public List<String> listarNomesGalerias() {

        List<String> galerias = new ArrayList<>();

        try {
            galerias = galeriaStorageService.listarNomesGalerias();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return galerias;
    }


    /**
     * Busca uma galeria completa pelo nome da galeria
     *
     * @return
     */
    @RequestMapping(value = "buscarPorNome", method = RequestMethod.GET)
    public Galeria buscarPorNome(@RequestParam(value = "nomeGaleria") String nomeGaleria) {

        Galeria galeria = new Galeria();
        galeria.setNomeGaleria(nomeGaleria);

        try {
            galeriaStorageService.buscarInformacoesGaleria(galeria);
            galeriaStorageService.listarImagensGaleria(galeria);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return galeria;
    }



    @RequestMapping(value = "montarThumbnails", method = RequestMethod.GET)
    public String montarThumbnails() {

        try {
            return htmlUtils.montarGalerias(galerias);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }




    @RequestMapping(value = "montarModais", method = RequestMethod.GET)
    public String montarModais() {

        try {
            return htmlUtils.montarTodosModais(galerias);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }








    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String uploadGaleria(@RequestParam(value = "arquivos", required = true) MultipartFile[] arquivos,
                              @RequestParam(value = "nome-galeria") String nomeGaleria
                            ) {

        System.out.print("ok");

        return "ok";


    }


//    @RequestMapping(value = "upload", method = RequestMethod.POST)
//    public void uploadGaleria(@RequestParam(value = "arquivos", required = true) MultipartFile[] arquivos,
//                              @RequestParam(value = "tituloGaleria", required = true) String tituloGaleria
//                              ) {
//
//        try {
//
//             galeriaStorageService.upload(arquivos, tituloGaleria);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (GeneralSecurityException e) {
//            e.printStackTrace();
//        }
//
//    }



}
