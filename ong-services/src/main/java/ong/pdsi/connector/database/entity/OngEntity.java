package ong.pdsi.connector.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ong.pdsi.domain.ong.OngType;

@Entity
@Table(name = "tb_ong")
public class OngEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ong")
	private Integer id;
	
	@Column(name = "nm_ong")
	private String name;
	
	@Column(name = "descricao")
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo")
	private OngType type;
	
	private String cnpj;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OngType getType() {
		return type;
	}

	public void setType(OngType type) {
		this.type = type;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}