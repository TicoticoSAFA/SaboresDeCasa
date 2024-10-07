package com.example.saboresdecasa.controladores;

import com.example.saboresdecasa.models.Cliente;
import com.example.saboresdecasa.servicios.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteControler {

        private ClienteService clienteService;

        @GetMapping("/listar")
        public List<Cliente> getAllClientes(){

            return clienteService.getAll();
        }

        @GetMapping()
        public Cliente getByIdCliente(@RequestParam Integer id){
            return clienteService.getById(id);
        }

        @GetMapping("/get/{id}")
        public Cliente getByIdPath (@PathVariable Integer id){
            return clienteService.getById(id);
        }

        @PostMapping()
        public Cliente save(@RequestBody Cliente cliente){
            return clienteService.guardar(cliente);
        }

        @DeleteMapping()
        public void delete(@RequestParam Integer id){
            clienteService.eliminar(id);
        }
}
