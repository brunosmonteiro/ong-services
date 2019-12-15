package ong.pdsi.connector.database.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "tb_evento")
@Entity
public class EventEntity {

	@Id
	@Column(name = "id_evento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "descricao")
	private String description;
	
	@Column(name = "nome")
	private String name;
	
	@ManyToOne(targetEntity = OngEntity.class)
	@JoinColumn(name = "id_ong")
	private OngEntity responsibleOng;
	
	@ManyToMany
	@JoinTable(name = "evento_usuario", 
		joinColumns = {@JoinColumn(name = "id_evento")}, 
		inverseJoinColumns = {@JoinColumn(name = "id_usuario")}
	)
	List<UserEntity> participants;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OngEntity getResponsibleOng() {
		return responsibleOng;
	}

	public void setResponsibleOng(OngEntity responsibleOng) {
		this.responsibleOng = responsibleOng;
	}

	public List<UserEntity> getParticipants() {
		return participants;
	}

	public void setParticipants(List<UserEntity> participants) {
		this.participants = participants;
	}
}