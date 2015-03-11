package sds.alfred.springapp.web.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sds.alfred.springapp.entities.bankaccount.Accounting;
import sds.alfred.springapp.services.account.BankAccountService;

@Controller
@RequestMapping("/rest/admin/account_management")
public class BankAccountAdminResource {

	@Autowired
	private BankAccountService bankAccountService;
	
	@RequestMapping(value="hello", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String hello(){
		return "Hello World!";
	}
	@RequestMapping(value="accountingList", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Page<Accounting> getPagingAccounting( @RequestParam( value = "rank", required = false ) Integer rank ){
		return this.bankAccountService.findAllAccounting( rank );
	}
}
