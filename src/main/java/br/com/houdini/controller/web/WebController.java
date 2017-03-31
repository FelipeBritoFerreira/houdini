package br.com.houdini.controller.web;

import br.com.houdini.service.StorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by Felipe Brito Ferreira on 06/02/2017.
 *
 * <p>Controller para uso exclusivo das telas do sistema.</p>
 *
 */
@Controller
public class WebController {

    /**
     * Inicia a tela principal do site
     */
    @RequestMapping(value = "/")
    public String home(Model model) {
        return "home";
    }




    /**
     * Inicia a tela de upload de arquivos
     * @return
     */
    @RequestMapping(value = "/arquivo", method = RequestMethod.GET)
    public String fileUpload() {
        return "file";
    }

    /**
     * Inicia a tela de upload de arquivos
     * @return
     */
    @RequestMapping(value = "/dropzone", method = RequestMethod.GET)
    public String dropzone() {
        return "dropzone";
    }


}
