package com.example.prova.Viagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinoService {
    @Autowired
    private DestinoRepository destinoRepository;

    public List<Destino> listarTodos() {
        return destinoRepository.findAll();
    }

    public Destino salvar(Destino destino) {
        return destinoRepository.save(destino);
    }

    public void deletar(Long id) {
        destinoRepository.deleteById(id);
    }
}
