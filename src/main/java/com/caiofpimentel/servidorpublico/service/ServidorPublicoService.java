package com.caiofpimentel.servidorpublico.service;

import java.util.List;
import java.util.Optional;

import com.caiofpimentel.servidorpublico.model.ServidorPublico;

public interface ServidorPublicoService {


    List<ServidorPublico> listAll();

    Optional<ServidorPublico> listByMatricula(Long matricula);



}
