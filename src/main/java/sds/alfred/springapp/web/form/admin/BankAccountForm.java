package sds.alfred.springapp.web.form.admin;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import sds.alfred.springapp.entities.bankaccount.AccountType;
import sds.alfred.springapp.entities.bankaccount.BankAccount;

public class BankAccountForm {

	@NotEmpty
	private String name;
	private String number;
	private String iban;
	@NotNull
	private Integer type;
	
	public BankAccount create(){
		BankAccount bankAccount = new BankAccount();
		bankAccount.setName( this.getName() );
		bankAccount.setNumber( this.getNumber() );
		bankAccount.setIban( this.getIban() );
		AccountType accountType = new AccountType();
		accountType.setId( this.getType() );
		bankAccount.setAccountType( accountType );
		return bankAccount;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}
