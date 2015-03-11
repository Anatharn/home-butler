package sds.alfred.springapp.web.form.account;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import sds.alfred.springapp.entities.bankaccount.Accounting;
import sds.alfred.springapp.entities.bankaccount.BankAccount;
import sds.alfred.springapp.entities.bankaccount.BankCheck;
import sds.alfred.springapp.entities.bankaccount.Entry;

public class EntryForm {

	public Integer accounting;
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	public Date date;
	public String third_party;
	public String detail;
	public Integer bank_check_number_id;
	@NotNull
	public Float total;
	@NotNull
	public Integer bank_account;
	public String has_been_checked;
	
	public Entry getEntity(){
		Entry entry = new Entry();
		if( this.accounting != null ){
			Accounting accounting = new Accounting();
			accounting.setId( this.accounting );
			entry.setAccounting( accounting );
		}
		entry.setDate( this.date );
		if( this.bank_check_number_id != null ){
			BankCheck bankCheck = new BankCheck();
			bankCheck.setId( this.bank_check_number_id );
			entry.setBankCheck( bankCheck );
		}
		entry.setTotal( this.total );
		if( this.bank_account != null ){
			BankAccount bankAccount = new BankAccount();
			bankAccount.setId( this.bank_account );
			entry.setBankAccount( bankAccount );
		}
		entry.setDetail( this.detail );
		if( this.has_been_checked != null && this.has_been_checked.equalsIgnoreCase( "true" ) )
			entry.setHasBeenChecked( true );
		else
			entry.setHasBeenChecked( false );
		return entry;
	}
	
	public Integer getAccounting() {
		return accounting;
	}
	public void setAccounting(Integer accounting) {
		this.accounting = accounting;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getThird_party() {
		return third_party;
	}
	public void setThird_party(String third_party) {
		this.third_party = third_party;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Integer getBank_check_number_id() {
		return bank_check_number_id;
	}
	public void setBank_check_number_id(Integer bank_check_number_id) {
		this.bank_check_number_id = bank_check_number_id;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public Integer getBank_account() {
		return bank_account;
	}
	public void setBank_account(Integer bank_account) {
		this.bank_account = bank_account;
	}
	public String getHas_been_checked() {
		return has_been_checked;
	}
	public void setHas_been_checked(String has_been_checked) {
		this.has_been_checked = has_been_checked;
	}
}
