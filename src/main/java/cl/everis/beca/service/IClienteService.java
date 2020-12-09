package cl.everis.beca.service;

import cl.everis.beca.entity.Cliente;

import java.util.List;

public interface IClienteService {
	
	public List<Cliente> findAll();

    public Cliente findById(Long idCliente);

    public void save(Cliente cliente);
    
    public void update(Cliente cliente, Long idCliente);

    public void deleteById(Long idCliente);

}
