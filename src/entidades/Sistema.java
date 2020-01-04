package entidades;

import java.io.Serializable;

public class Sistema implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer codSistema;
	private String descSistema;
	
	public Sistema() {
	}
	public Sistema(Integer codSistema, String descSistema) {
		this.codSistema = codSistema;
		this.descSistema = descSistema;
	}
	
	public Integer getCodSistema() {
		return codSistema;
	}
	public void setCodSistema(Integer codSistema) {
		this.codSistema = codSistema;
	}
	public String getDescSistema() {
		return descSistema;
	}
	public void setDescSistema(String descSistema) {
		this.descSistema = descSistema;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codSistema == null) ? 0 : codSistema.hashCode());
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
		Sistema other = (Sistema) obj;
		if (codSistema == null) {
			if (other.codSistema != null)
				return false;
		} else if (!codSistema.equals(other.codSistema))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Sistema [codSistema=" + codSistema + ", descSistema=" + descSistema + "]";
	}
}
