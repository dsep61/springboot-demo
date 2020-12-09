package cl.everis.beca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.everis.beca.entity.Cliente;
import cl.everis.beca.service.ClienteService;



//Indiciamos que es un controlador rest
//URL: localhost/api/*
@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
    private ClienteService clienteService;
	
    @GetMapping("/clientes")
    public List<Cliente> findAll(){
        //retornará todos los usuarios
        return clienteService.findAll();
    }

    @GetMapping("/cliente/{idCliente}")
    public Cliente getCliente(@PathVariable Long idCliente){
        Cliente cliente = clienteService.findById(idCliente);

        if(cliente == null) {
            throw new RuntimeException("El id del cliente no se ha encontrado -" + idCliente);
        }
        //retornará al usuario con id pasado en la url
        return cliente;
    }

    @PostMapping("/clientes")
    public Cliente addCliente(@RequestBody Cliente cliente) {
        //Este metodo guardará al usuario enviado
        clienteService.save(cliente);

        return cliente;

    }

    @PutMapping("/clientes/{idCliente}")
    public Cliente updateCliente(@RequestBody Cliente cliente, @PathVariable Long idCliente) {

    	clienteService.update(cliente, idCliente);

        //este metodo actualizará al usuario enviado con el id pasado en la url

        return cliente;
    }

    @DeleteMapping("clientes/{idCliente}")
    public String deteteCliente(@PathVariable Long idCliente) {

        Cliente cliente = clienteService.findById(idCliente);

        if(cliente == null) {
            throw new RuntimeException("El id del cliente no se ha encontrado -" + idCliente);
        }

        clienteService.deleteById(idCliente);

        //Esto método, recibira el id de un usuario por URL y se borrará de la bd.
        return "Cliente eliminado con el id - " + idCliente;
    }

}
