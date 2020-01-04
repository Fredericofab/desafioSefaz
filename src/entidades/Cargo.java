package entidades;

import java.io.Serializable;

public class Cargo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer codCargo;
	private String descCargo;
	
	public Cargo() {
	}
	public Cargo(Integer codCargo, String descCargo) {
		this.codCargo = codCargo;
		this.descCargo = descCargo;
	}
	
	public Integer getCodCargo() {
		return codCargo;
	}
	public void setCodCargo(Integer codCargo) {
		this.codCargo = codCargo;
	}
	public String getDescCargo() {
		return descCargo;
	}
	public void setDescCargo(String descCargo) {
		this.descCargo = descCargo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCargo == null) ? 0 : codCargo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		if (codCargo == null) {
			if (other.codCargo != null)
				return false;
		} else if (!codCargo.equals(other.codCargo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Cargo [codCargo=" + codCargo + ", descCargo=" + descCargo + "]";
	}
}
