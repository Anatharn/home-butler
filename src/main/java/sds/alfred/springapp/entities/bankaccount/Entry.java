package sds.alfred.springapp.entities.bankaccount;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "entry")
public class Entry implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2073823655326854784L;

	@Id @GeneratedValue( strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn( name = "accounting_id", referencedColumnName="id"  )
	private Accounting accounting;
	@ManyToOne
	@JoinColumn( name = "bank_account_id", referencedColumnName="id"  )
	private BankAccount bankAccount;
	@ManyToOne
	@JoinColumn( name = "bank_check_number", referencedColumnName="id"  )
	private BankCheck bankCheck;
	@Column
	private Date date;
	@Column
	private String detail;
	@Column( name = "has_been_checked" )
	private Boolean hasBeenChecked;
	@ManyToOne
	@JoinColumn( name = "third_party_id", referencedColumnName="id"  )
	private ThirdParty thirdParty;
	@Column
	private Float total;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Accounting getAccounting() {
		return accounting;
	}
	public void setAccounting(Accounting accounting) {
		this.accounting = accounting;
	}
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	public BankCheck getBankCheck() {
		return bankCheck;
	}
	public void setBankCheck(BankCheck bankCheck) {
		this.bankCheck = bankCheck;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Boolean getHasBeenChecked() {
		return hasBeenChecked;
	}
	public void setHasBeenChecked(Boolean hasBeenChecked) {
		this.hasBeenChecked = hasBeenChecked;
	}
	public ThirdParty getThirdParty() {
		return thirdParty;
	}
	public void setThirdParty(ThirdParty thirdParty) {
		this.thirdParty = thirdParty;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
}
