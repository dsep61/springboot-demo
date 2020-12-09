package cl.everis.beca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.everis.beca.dao.ClienteDAO;
import cl.everis.beca.entity.Cliente;

@Service
public class ClienteService implements IClienteService{
	
	@Autowired
    private ClienteDAO clienteDAO;

	@Override
	public List<Cliente> findAll() {
		List<Cliente> listCliente= clienteDAO.findAll();
        return listCliente;
	}

	@Override
	public Cliente findById(Long idCliente) {
		Cliente cliente = clienteDAO.findById(idCliente);
        return cliente;
	}

	@Override
	public void save(Cliente cliente) {
		clienteDAO.save(cliente);
		
	}
	
	@Override
	public void update(Cliente cliente, Long idCliente) {
		clienteDAO.update(cliente, idCliente);
		
	}

	@Override
	public void deleteById(Long idCliente) {
		clienteDAO.deleteById(idCliente);
		
	}



}
