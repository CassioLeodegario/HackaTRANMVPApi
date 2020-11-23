package com.eufiscalizo.services;

import com.eufiscalizo.model.Infracao;
import com.eufiscalizo.model.InfracaoNoImage;
import com.eufiscalizo.repositories.InfracaoRepository;
import com.eufiscalizo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InfracaoService {


    @Autowired
    private InfracaoRepository repo;

    private static final String CAMINHO_ARQUIVOS = "\\\\s276\\e$\\DADOS\\DPGE\\AJFILE\\ASSISTIDO\\";


    public Infracao find(Long id) {
        Optional<Infracao> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Infracao.class.getName()));
    }

    public List<InfracaoNoImage> findAll() {
        return repo.findAllSimpleByQuery();
    }

    public Infracao insert(Infracao obj){
        obj.setId(null);
        obj =  repo.save(obj);
        return obj;
    }

    public Infracao save(Infracao obj){
        obj =  repo.save(obj);
        return obj;
    }

    public String salvarArquivos(Long id, MultipartFile[] files) {
        try {
            String ano = new SimpleDateFormat("yyyy").format(new Date());
            String mes = new SimpleDateFormat("MM").format(new Date());
            List<String> caminhoArquivos = new ArrayList<>();

            String destino = "";
            for (MultipartFile file : files) {
                file.getBytes();
            }
            return destino;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private void verificarDiretorio(String diretorio){
        File directory = new File(diretorio);
        if (!directory.exists()){
            directory.mkdirs();
        }
    }


}
