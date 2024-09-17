package com.example.prova.Viagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/viagens")
public class ViagemController {

    @Autowired
    private ViagemService viagemService;

    @Autowired
    private DestinoService destinoService;

    @GetMapping
    public List<Viagem> listarTodos() {
        return viagemService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viagem> buscarPorId(@PathVariable Long id) {
        Optional<Viagem> produto = viagemService.buscarPorId(id);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Viagem salvar(@RequestBody Viagem viagem) {
        // Ensure the destination is properly saved or referenced
        if (viagem.getDestino() != null && viagem.getDestino().getId() != null) {
            Destino destino = destinoService.listarTodos()
                    .stream()
                    .filter(d -> d.getId().equals(viagem.getDestino().getId()))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Destino não encontrado."));
            viagem.setDestino(destino);
        }
        return viagemService.salvar(viagem);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        viagemService.deletar(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Viagem> atualizarViagem(@PathVariable Long id, @RequestBody Viagem viagem) {
        Viagem viagemAtualizado = viagemService.atualizarViagem(id, viagem);
        return ResponseEntity.ok(viagemAtualizado);
    }

}
