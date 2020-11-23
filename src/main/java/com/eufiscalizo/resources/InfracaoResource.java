package com.eufiscalizo.resources;

import com.eufiscalizo.model.EnumSituacao;
import com.eufiscalizo.model.Infracao;
import com.eufiscalizo.model.InfracaoNoImage;
import com.eufiscalizo.services.InfracaoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping(value = "/infracao")
public class InfracaoResource {

    @Autowired
    private InfracaoService service;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Infracao> postSolicitacao(@RequestBody Infracao obj) {
        obj.setDataInclusao(new Date());
        obj.setSituacao(EnumSituacao.PENDENTE);
        obj = service.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Infracao> find(@PathVariable Long id){
        Infracao obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(path = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<InfracaoNoImage>> listar() {
        List<InfracaoNoImage> infracoes = service.findAll();
        return ResponseEntity.ok().body(infracoes);
    }

}
