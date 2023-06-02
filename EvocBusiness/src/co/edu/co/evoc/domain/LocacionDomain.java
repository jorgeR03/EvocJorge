package co.edu.co.evoc.domain;

import java.util.UUID;

public class LocacionDomain {
	
	private UUID identificador;
	private String direccion;
	private String descripcion;
	private int potencialElectoral;
	private ZonaDomain zona;

	public LocacionDomain(UUID identificador, String direccion, String descripcion, int potencialElectoral, ZonaDomain zona) {
		super();
		setIdentificador(identificador);
		setDireccion(direccion);
		setDescripcion(descripcion);
		setPotencialElectoral(potencialElectoral);
		setZona(zona);
	}
	public final UUID getIdentificador() {
		return identificador;
	}
	private final void setIdentificador(final UUID identificador) {
		this.identificador = identificador;
	}
	public final String getDireccion() {
		return direccion;
	}
	private final void setDireccion(final String direccion) {
		this.direccion = direccion;
	}
	public final String getDescripcion() {
		return descripcion;
	}
	private final void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}
	public final int getPotencialElectoral() {
		return potencialElectoral;
	}
	private final void setPotencialElectoral(final int potencialElectoral) {
		this.potencialElectoral = potencialElectoral;
	}
	public final ZonaDomain getZona() {
		return zona;
	}
	private final void setZona(final ZonaDomain zona) {
		this.zona = zona;
	}

}
