package sds.alfred.springapp.entities.bankaccount;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "bank_check" )
public class BankCheck implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6082473163324128127L;

	@Id @GeneratedValue( strategy = GenerationType.AUTO)
	private int id;
	@Column
	private int number;
	@Column
	private Boolean used;
	@Column
	private Boolean cancelled;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Boolean isUsed() {
		return used;
	}
	public void setUsed(Boolean used) {
		this.used = used;
	}
	public Boolean isCancelled() {
		return cancelled;
	}
	public void setCancelled(Boolean cancelled) {
		this.cancelled = cancelled;
	}
	
}
