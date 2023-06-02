package co.edu.co.evoc.domain;

import java.util.UUID;

public class PartidoDomain {
	
	private UUID identificador;
	private String nombre;
	private String sede;
	
	public PartidoDomain(UUID identificador, String nombre, String sede) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setSede(sede);
	}
	public final UUID getIdentificador() {
		return identificador;
	}
	private final void setIdentificador(final UUID identificador) {
		this.identificador = identificador;
	}
	public final String getNombre() {
		return nombre;
	}
	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	public final String getSede() {
		return sede;
	}
	private final void setSede(final String sede) {
		this.sede = sede;
	}

}
