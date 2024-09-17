package com.example.prova.Viagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ViagemService {
    @Autowired
    private ViagemRepository viagemRepository;

    public List<Viagem> listarTodos() {
        return viagemRepository.findAll();
    }
    public Optional<Viagem> buscarPorId(Long id) {
        return viagemRepository.findById(id);
    }

    public Viagem salvar(Viagem viagem) {
        return viagemRepository.save(viagem);
    }

    public void deletar(Long id) {
        viagemRepository.deleteById(id);
    }

    public Viagem atualizarViagem(Long id, Viagem viagem) {
        Viagem viagemExistente = viagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar a viagem com o id: " + id));

        viagemExistente.setNome(viagem.getNome());
        viagemExistente.setValor(viagem.getValor());
        viagemExistente.setdataSaida(viagem.getdataSaida());
        viagemExistente.setdataChegada(viagem.getdataChegada());

        return viagemRepository.save(viagemExistente);
    }

}





