package sds.alfred.springapp.web.form.admin;

import org.hibernate.validator.constraints.NotEmpty;

public class AccountTypeForm {

	@NotEmpty( message = "Ce champs ne peut pas être vide." )
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
