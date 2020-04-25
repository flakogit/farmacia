package cl.home.farmanet.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Rodrigo Sepúlveda
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Farmacia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3025381881251204826L;
	private String comuna_nombre;
	private String local_direccion;
	private String local_lat;
	private String local_lng;
	private String local_nombre;
	private String local_telefono;

	public String getComuna_nombre() {
		return comuna_nombre;
	}

	public void setComuna_nombre(String comuna_nombre) {
		this.comuna_nombre = comuna_nombre;
	}

	public String getLocal_direccion() {
		return local_direccion;
	}

	public void setLocal_direccion(String local_direccion) {
		this.local_direccion = local_direccion;
	}

	public String getLocal_lat() {
		return local_lat;
	}

	public void setLocal_lat(String local_lat) {
		this.local_lat = local_lat;
	}

	public String getLocal_lng() {
		return local_lng;
	}

	public void setLocal_lng(String local_lng) {
		this.local_lng = local_lng;
	}

	public String getLocal_nombre() {
		return local_nombre;
	}

	public void setLocal_nombre(String local_nombre) {
		this.local_nombre = local_nombre;
	}

	public String getLocal_telefono() {
		return local_telefono;
	}

	public void setLocal_telefono(String local_telefono) {
		this.local_telefono = local_telefono;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Farmacia [comuna_nombre=" + comuna_nombre + ", local_direccion=" + local_direccion + ", local_lat="
				+ local_lat + ", local_lng=" + local_lng + ", local_nombre=" + local_nombre + ", local_telefono="
				+ local_telefono + "]";
	}

}
