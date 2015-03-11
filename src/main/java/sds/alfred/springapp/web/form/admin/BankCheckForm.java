package sds.alfred.springapp.web.form.admin;

import javax.validation.constraints.NotNull;

import sds.alfred.springapp.entities.bankaccount.BankCheck;

public class BankCheckForm {

	@NotNull
	private Integer number;
	
	private String cancelled;

	public BankCheck getEntity(){
		BankCheck bankCheck = new BankCheck();
		bankCheck.setNumber( this.number );
		if( this.cancelled != null )
			bankCheck.setCancelled( true );
		return bankCheck;
	}
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getCancelled() {
		return cancelled;
	}
	public void setCancelled( String  cancelled) {
		this.cancelled = cancelled;
	}
}
