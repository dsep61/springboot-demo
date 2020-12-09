package cl.everis.beca.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.everis.beca.entity.Cliente;

@Repository
public class ClienteDAO implements IClienteDAO{
	
	@Autowired
    private EntityManager entityManager;

	@Override
	public List<Cliente> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);

        Query<Cliente> theQuery = currentSession.createQuery("from Cliente", Cliente.class);

        List<Cliente> clientes = theQuery.getResultList();

        return clientes;
	}

	@Override
	public Cliente findById(Long idCliente) {
		Session currentSession = entityManager.unwrap(Session.class);

		Cliente cliente = currentSession.get(Cliente.class, idCliente);

	    return cliente;
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		Session currentSession = entityManager.unwrap(Session.class);

		@SuppressWarnings("unchecked")
		Query<Cliente> theQuery = currentSession.createQuery("insert into Cliente(rut, nombre, apellido)" +
                "select rut, nombre, apellido from Cliente");
		
		 theQuery.executeUpdate();
		
	}
	
	@Override
	@Transactional
	public void update(Cliente cliente, Long idCliente) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		String hql = "UPDATE Cliente set rut = :rut, nombre = :nombre, apellido = :apellido "  + 
	             "WHERE id = :idCliente";
		
		@SuppressWarnings("unchecked")
		Query<Cliente> theQuery = currentSession.createQuery(hql);
		
		theQuery.setParameter("rut", cliente.getRut());
		theQuery.setParameter("nombre", cliente.getNombre());
		theQuery.setParameter("apellido", cliente.getApellido());
		theQuery.setParameter("idCliente", idCliente);
		
		theQuery.executeUpdate();
		
	}

	@Override
	@Transactional
	public void deleteById(Long idCliente) {
		Session currentSession = entityManager.unwrap(Session.class);

		@SuppressWarnings("unchecked")
		Query<Cliente> theQuery = currentSession.createQuery("delete from Cliente where id=:idCliente");

        theQuery.setParameter("idCliente", idCliente);
        theQuery.executeUpdate();
		
	}
	


}
