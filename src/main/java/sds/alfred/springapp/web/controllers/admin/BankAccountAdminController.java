package sds.alfred.springapp.web.controllers.admin;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sds.alfred.springapp.entities.bankaccount.AccountType;
import sds.alfred.springapp.entities.bankaccount.Accounting;
import sds.alfred.springapp.entities.bankaccount.BankAccount;
import sds.alfred.springapp.entities.bankaccount.BankCheck;
import sds.alfred.springapp.services.account.BankAccountService;
import sds.alfred.springapp.web.form.admin.AccountTypeForm;
import sds.alfred.springapp.web.form.admin.AccountingForm;
import sds.alfred.springapp.web.form.admin.BankAccountForm;
import sds.alfred.springapp.web.form.admin.BankCheckForm;

@Controller
public class BankAccountAdminController {
	
	private final static String URL_ROOT 				= "admin/account_management/";
	
	private final static String URL_PAGE_ACCOUNT_DATA	= URL_ROOT + "account_data_management";
	private final static String URL_ADD_ACCOUNT_TYPE 	= URL_ROOT + "add_account_type";
	private final static String URL_ADD_ACCOUNTING 		= URL_ROOT + "add_accounting";
	private final static String URL_DEL_ACCOUNT_TYPE	= URL_ROOT + "del_account_type";
	private final static String URL_DEL_ACCOUNTING		= URL_ROOT + "del_accounting";
	
	private final static String URL_PAGE_BANK_ACCOUNT	= URL_ROOT + "bank_account_management";
	private final static String URL_ADD_BANK_ACCOUNT	= URL_ROOT + "add_bank_account";
	private final static String URL_DEL_BANK_ACCOUNT	= URL_ROOT + "del_bank_account";

	private final static String URL_PAGE_BANK_CHECK		= URL_ROOT + "bank_check_management";
	private final static String URL_ADD_BANK_CHECK		= URL_ROOT + "add_bank_check";
	private final static String URL_DEL_BANK_CHECK		= URL_ROOT + "del_bank_check";
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@RequestMapping( value = URL_DEL_BANK_CHECK, method = RequestMethod.POST )
	public String deleteBankCheck( @RequestParam( "id" )  int bankCheckId, Model model ){
		this.bankAccountService.deleteBankCheckById( bankCheckId );
		
		this.loadBankCheckPage( model,  new BankCheckForm() );
		
		return URL_PAGE_BANK_CHECK;
	}
	
	@RequestMapping( value = URL_ADD_BANK_CHECK, method = RequestMethod.POST )
	public String addBankCheck( @ModelAttribute @Valid BankCheckForm form,  BindingResult result, Model model ){
		if( !result.hasErrors() ){
			BankCheck bankCheck = form.getEntity();
			this.bankAccountService.addBankCheck( bankCheck );
			form = new BankCheckForm();
		}
		this.loadBankCheckPage( model, form );
		
		return URL_PAGE_BANK_CHECK;
	}
	@RequestMapping( value = URL_PAGE_BANK_CHECK, method = RequestMethod.GET )
	public String loadBankCheckPage( Model model ){
		this.loadBankCheckPage( model, new BankCheckForm() );
		
		return URL_PAGE_BANK_CHECK;
	}
	
	@RequestMapping( value = URL_DEL_BANK_ACCOUNT, method = RequestMethod.POST )
	public String deleteBankAccount( @RequestParam( "id" )  int bankAccountId, Model model ){
		this.bankAccountService.deleteBankAccountById( bankAccountId );
		
		this.loadBankAccountPage( model, new BankAccountForm() );
		
		return URL_PAGE_BANK_ACCOUNT;
	}
	
	@RequestMapping( value = URL_ADD_BANK_ACCOUNT, method = RequestMethod.POST )
	public String addBankAccount( @ModelAttribute @Valid BankAccountForm form,  BindingResult result, Model model ){
		if( !result.hasErrors() ){
			BankAccount bankAccount = form.create();
			this.bankAccountService.addBankAccount( bankAccount );
			form = new BankAccountForm();
		}
		this.loadBankAccountPage( model, form );
		
		return URL_PAGE_BANK_ACCOUNT;
	}
	
	@RequestMapping( value = URL_PAGE_BANK_ACCOUNT, method = RequestMethod.GET )
	public String loadBankAccountPage( Model model){
		this.loadBankAccountPage(model, new BankAccountForm() );
		
		return URL_PAGE_BANK_ACCOUNT;
	}
	
	@RequestMapping( value = URL_PAGE_ACCOUNT_DATA, method = RequestMethod.GET )
	public String loadAccountDataPage( Model model, @RequestParam( value = "rank", required = false ) Integer rank){
		if( rank == null )
			rank = 0;
		this.loadAccountDataPage( model, new AccountTypeForm(), new AccountingForm(), rank );

		return URL_PAGE_ACCOUNT_DATA;
	}
	
	@RequestMapping( value = URL_ADD_ACCOUNT_TYPE, method = RequestMethod.POST )
	public String addAccountType( @ModelAttribute @Valid AccountTypeForm form,  BindingResult result, Model model ){
		if( !result.hasErrors() ){
			AccountType accountType = new AccountType();
			accountType.setName( form.getName() );
			this.bankAccountService.addAccountType( accountType );
			form = new AccountTypeForm();
		}
		
		this.loadAccountDataPage( model, form, new AccountingForm(), 0 );
		
		return URL_PAGE_ACCOUNT_DATA;
	}
	
	@RequestMapping( value = URL_ADD_ACCOUNTING, method = RequestMethod.POST )
	public String addAccounting( @ModelAttribute @Valid AccountingForm form,  BindingResult result, Model model ){
		if( !result.hasErrors() ){
			Accounting accounting = form.getEntity();
			this.bankAccountService.addAccounting( accounting );
			form = new AccountingForm();
		}
		
		this.loadAccountDataPage( model, new AccountTypeForm(), form, 0 );
		
		return URL_PAGE_ACCOUNT_DATA;
	}
	
	@RequestMapping( value = URL_DEL_ACCOUNT_TYPE, method = RequestMethod.POST )
	public String deleteAccountType( @RequestParam( "id" )  int accountTypeId, Model model ){
		this.bankAccountService.deleteAccountTypeById( accountTypeId );
		
		this.loadAccountDataPage( model, new AccountTypeForm(), new AccountingForm(), 0 );
		
		return URL_PAGE_ACCOUNT_DATA;
	}
	
	@RequestMapping( value = URL_DEL_ACCOUNTING, method = RequestMethod.POST )
	public String deleteAccounting( @RequestParam( "id" )  int accountingId, Model model ){
		this.bankAccountService.deleteAccountingById( accountingId );
		
		this.loadAccountDataPage( model, new AccountTypeForm(), new AccountingForm(), 0 );
		
		return URL_PAGE_ACCOUNT_DATA;
	}
	
	private void loadBankAccountPage( Model model, BankAccountForm form ){
		List<AccountType> types = bankAccountService.findAllAccountType();
		Map<Integer,String> accountTypeList = new LinkedHashMap<Integer,String>();
		for( AccountType type : types )
			accountTypeList.put( type.getId(), type.getName() );
		model.addAttribute( "accountTypeList", accountTypeList );
		
		List<BankAccount> bankAccountList = this.bankAccountService.findAllBankAccount();
		model.addAttribute( "bankAccountList" , bankAccountList );
		
		model.addAttribute( "bankAccountForm", form );
	}
	
	private void loadAccountDataPage( Model model, AccountTypeForm accountTypeForm, AccountingForm accountingForm, int accountingRank ){
		List<AccountType> types = this.bankAccountService.findAllAccountType();
		model.addAttribute( "accountTypes", types );
		model.addAttribute( "accountTypeForm", accountTypeForm );
		
		Page<Accounting> accountingList = this.bankAccountService.findAllAccounting( accountingRank );
		model.addAttribute( "accountingList", accountingList );
		model.addAttribute( "accountingForm", accountingForm );
	}
	private void loadBankCheckPage( Model model, BankCheckForm form){
		List<BankCheck> bankCheckList = this.bankAccountService.findAllBankCheck();
		
		model.addAttribute("bankCheckList", bankCheckList);
		model.addAttribute( "bankCheckForm", form);
	}
}
