package sds.alfred.springapp.entities.bankaccount;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "bank_account" )
public class BankAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4975098731644769049L;
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO )
	private int id;
	@Column(nullable=false)
	private String name;
	@Column
	private String number;
	@Column
	private String iban;
	@ManyToOne
	@JoinColumn( name = "type", referencedColumnName="id"  )
	private AccountType accountType;
	
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
}
