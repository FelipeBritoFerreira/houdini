package br.com.houdini.controller.rest;

import br.com.houdini.beans.Email;
import br.com.houdini.dto.EmailResponseDTO;
import br.com.houdini.service.EnviarEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

/**
 * Created by FBF0113 on 09/02/2017.
 */
@RestController
public class EmailRestController {

    @Autowired
    private EnviarEmailService enviarEmailService;


    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public EmailResponseDTO enviarEmail(@RequestBody Email email) {

        EmailResponseDTO response = new EmailResponseDTO();

        try {
            enviarEmailService.enviarEmail(email);
            response.setErro(false);

        } catch (MessagingException e) {
            response.setErro(true);
            e.printStackTrace();
        }

        return response;
    }



}
