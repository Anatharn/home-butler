package sds.alfred.springapp.web.controllers.account;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sds.alfred.springapp.entities.bankaccount.Accounting;
import sds.alfred.springapp.entities.bankaccount.BankAccount;
import sds.alfred.springapp.entities.bankaccount.BankCheck;
import sds.alfred.springapp.entities.bankaccount.Entry;
import sds.alfred.springapp.entities.bankaccount.ThirdParty;
import sds.alfred.springapp.services.account.BankAccountService;
import sds.alfred.springapp.web.form.account.EntryForm;
import sds.alfred.springapp.web.form.utils.AutocompleteForm;

@Controller
@RequestMapping( "account/" )
public class BankAccountController {

	@Autowired
	private BankAccountService bankAccountService;
	
	@RequestMapping( value = "account", method = RequestMethod.GET )
	public String loadPage( Model model ){
		List<Accounting> accountingList = this.bankAccountService.findAllAccounting();
		List<BankAccount> bankAccountList = this.bankAccountService.findAllBankAccount();
		Page<Entry> entryList = this.bankAccountService.findAllEntrySortByDate();
		List<BankCheck> bankCheckList = this.bankAccountService.findBankCheckAvailable();
		
		model.addAttribute( "bankCheckList", bankCheckList );
		model.addAttribute( "entryList", entryList );
		model.addAttribute( "bankAccountList" , bankAccountList );
		model.addAttribute( "accountingList", accountingList );
		
		return "account/account";
	}
	@RequestMapping(value="addEntry", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addEntry( @RequestBody @Valid EntryForm form, BindingResult result ){
		if( result.hasErrors() ){
			StringBuilder sb = new StringBuilder();
			for( ObjectError objectError : result.getAllErrors() ){
				sb.append( objectError.getCode() );
				sb.append( " " );
				sb.append( objectError.getDefaultMessage() );
				sb.append( "\r\n" );
			}
			return new ResponseEntity<String>(sb.toString() , HttpStatus.BAD_REQUEST );
		}
		Entry entry = form.getEntity();
		ThirdParty thirdParty = this.bankAccountService.addThirdparty( form.getThird_party() );
		entry.setThirdParty( thirdParty );
		try {
			this.bankAccountService.addEntry( entry );
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST );
		}
		return new ResponseEntity<String>("yes", HttpStatus.OK );
	}
	@RequestMapping(value="autoCompleteThirdparty", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<String> autoCompleteThirdparty( @RequestBody AutocompleteForm form ){
		return this.bankAccountService.findThirdPartyByName( form.getTerm(), 5 );
	}

}
