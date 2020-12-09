package cl.everis.beca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.everis.beca.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}