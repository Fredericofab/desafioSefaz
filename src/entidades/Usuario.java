package entidades;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long cpf;
	private String nome;
	private Integer ramal;
	private String email;
	
	private Cargo cargo;
	private Orgao orgao;
	
	public Usuario() {
	}
	public Usuario(Long cpf, String nome, Integer ramal, String email, Cargo cargo, Orgao orgao) {
		this.cpf = cpf;
		this.nome = nome;
		this.ramal = ramal;
		this.email = email;
		this.cargo = cargo;
		this.orgao = orgao;
	}

	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getRamal() {
		return ramal;
	}
	public void setRamal(Integer ramal) {
		this.ramal = ramal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public Orgao getOrgao() {
		return orgao;
	}
	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Usuario other = (Usuario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [cpf=" + cpf + ", nome=" + nome + ", ramal=" + ramal + ", email=" + email + ", cargo=" + cargo
				+ ", orgao=" + orgao + "]";
	}
}
