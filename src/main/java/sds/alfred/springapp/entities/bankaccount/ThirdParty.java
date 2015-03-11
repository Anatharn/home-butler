package sds.alfred.springapp.entities.bankaccount;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "third_party" )
public class ThirdParty implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8928587909578779735L;

	@Id @GeneratedValue( strategy = GenerationType.AUTO )
	private int id;
	@Column
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
