package entidades;

import java.io.Serializable;

public class Orgao implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer codOrgao;
	private String descOrgao;
	
	public Orgao() {
	}
	public Orgao(Integer codOrgao, String descOrgao) {
		this.codOrgao = codOrgao;
		this.descOrgao = descOrgao;
	}

	public Integer getCodOrgao() {
		return codOrgao;
	}
	public void setCodOrgao(Integer codOrgao) {
		this.codOrgao = codOrgao;
	}
	public String getDescOrgao() {
		return descOrgao;
	}
	public void setDescOrgao(String descOrgao) {
		this.descOrgao = descOrgao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codOrgao == null) ? 0 : codOrgao.hashCode());
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
		Orgao other = (Orgao) obj;
		if (codOrgao == null) {
			if (other.codOrgao != null)
				return false;
		} else if (!codOrgao.equals(other.codOrgao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Orgao [codOrgao=" + codOrgao + ", descOrgao=" + descOrgao + "]";
	}
}
