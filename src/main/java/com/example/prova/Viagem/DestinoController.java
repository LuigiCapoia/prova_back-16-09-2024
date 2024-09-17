package com.example.prova.Viagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinos")
public class DestinoController {
    @Autowired
    private DestinoService destinoService;

    @GetMapping
    public List<Destino> listarTodos() {
        return destinoService.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Destino salvar(@RequestBody Destino destino) {
        return destinoService.salvar(destino);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        destinoService.deletar(id);
    }
}
