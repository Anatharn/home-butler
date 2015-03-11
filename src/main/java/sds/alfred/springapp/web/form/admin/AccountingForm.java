package sds.alfred.springapp.web.form.admin;

import org.hibernate.validator.constraints.NotEmpty;

import sds.alfred.springapp.entities.bankaccount.Accounting;

public class AccountingForm {
	
	@NotEmpty( message = "Ce champs ne peut pas �tre vide." )
	private String name;

	public Accounting getEntity(){
		Accounting accounting = new Accounting();
		accounting.setName( this.getName() );		
		
		return accounting;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
