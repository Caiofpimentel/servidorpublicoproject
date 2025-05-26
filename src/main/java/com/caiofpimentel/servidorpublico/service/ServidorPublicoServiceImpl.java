package com.caiofpimentel.servidorpublico.service;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.caiofpimentel.servidorpublico.model.ServidorPublico;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ServidorPublicoServiceImpl implements ServidorPublicoService {

    // Implement the methods from the ServidorPublicoService interface here
    // For example:
    private final String SERVIDOR = "data\\servidorpublico.json";


    @Override
    public List<ServidorPublico> listAll() {
        // Logic to list all servidores publicos
        try {
            TypeReference<List<ServidorPublico>> typeRef = new TypeReference<List<ServidorPublico>>() {};

            InputStream inputStream = TypeReference.class.getResourceAsStream(SERVIDOR);
            
            List<ServidorPublico> servidorespublico = new ObjectMapper().readValue(inputStream, typeRef);
            
            return servidorespublico;



        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exceção" + e.getMessage());

            return null;
        }
        
    }

    @Override
    public Optional<ServidorPublico> listByMatricula(Long matricula) {
        // Logic to find a servidor publico by matricula
        try{
            TypeReference<List<ServidorPublico>> typeRef = new TypeReference<List<ServidorPublico>>() {};

            InputStream inputStream = TypeReference.class.getResourceAsStream(SERVIDOR);
            
            List<ServidorPublico> servidorespublico = new ObjectMapper().readValue(inputStream, typeRef);
            
            Optional<ServidorPublico> servidorEncontrado = servidorespublico.stream()
                .filter(s -> s.matricula().equals(matricula))
                .findFirst();

            return servidorEncontrado;
       
        }
        catch (Exception e) {
            System.out.println("Exceção" + e.getMessage());
            return null;}

    }
        


       
}

    // Add any other methods as needed


