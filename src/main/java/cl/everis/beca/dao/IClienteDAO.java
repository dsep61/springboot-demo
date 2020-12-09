package cl.everis.beca.dao;

import java.util.List;

import cl.everis.beca.entity.Cliente;

public interface IClienteDAO {
	
	public List<Cliente> findAll();

    public Cliente findById(Long id);

    public Cliente save(Cliente cliente);
    
    public void update(Cliente cliente, Long idCliente);

    public void deleteById(Long id);

}
