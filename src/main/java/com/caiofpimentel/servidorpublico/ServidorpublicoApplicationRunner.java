package com.caiofpimentel.servidorpublico;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.caiofpimentel.servidorpublico.model.ServidorPublico;
import com.caiofpimentel.servidorpublico.service.ServidorPublicoService;

import jakarta.annotation.PostConstruct;



@Configuration
public class ServidorpublicoApplicationRunner implements CommandLineRunner{ 

    private ServidorPublicoService servidorService;
    
    @Autowired
    public void setServidorPublicoService(ServidorPublicoService servidorService) {
       
        this.servidorService = servidorService;
    }
    @PostConstruct
    public void listAll() {
        // This method can be used to list all servidores publicos
       List<ServidorPublico> servidorespublicos = servidorService.listAll();
       if (servidorespublicos.size() != 0) {
           servidorespublicos.forEach(System.out::println);
       } else {
           System.out.println("Nenhum servidor público encontrado.");
        
       }

       
    }
    @PostConstruct
    public void listByMatricula() {
        // This method can be used to find a servidor publico by matricula
        Long matricula = Long.parseLong(JOptionPane.showInputDialog("Digite a matrícula do servidor público:"));
        Optional<ServidorPublico> servidorEncontrado = servidorService.listByMatricula(matricula);
        if (servidorEncontrado.isPresent()) {
            System.out.println(servidorEncontrado.get());
        } else {
            System.out.println("Servidor público não encontrado.");
        }
    }

    @Override
    public void run(String... args) throws Exception {
        // This method can be used to execute code after the application has started

        
    }
    
}
