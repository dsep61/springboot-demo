package cl.everis.beca.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cliente")
public class Cliente {
	
    /**
     * Genera un valor de id aleatorio
     * strategy = Define la estrategia a utilizar para generar el id 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id")
	private Long id; 	// Atributo que representa el ID de la clase del usuario
	
    @Column(name="rut")
	private String rut; //Atributo que representa el rut del usuario
	
    @Column(name="nombre")
	private String nombre; // Atributo que representa el nombre  del usuario
	
    @Column(name="apellido")
	private String apellido; // Atributo que representa el apellido del usuario
    
    public Cliente() {}
    
	public Cliente(Long id, String rut, String nombre, String apellido, Date fechaNacimiento) {
		super();
		this.id = id;
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	

}
