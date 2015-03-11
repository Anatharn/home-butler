package sds.alfred.springapp.services.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sds.alfred.springapp.entities.bankaccount.AccountType;
import sds.alfred.springapp.entities.bankaccount.Accounting;
import sds.alfred.springapp.entities.bankaccount.BankAccount;
import sds.alfred.springapp.entities.bankaccount.BankCheck;
import sds.alfred.springapp.entities.bankaccount.Entry;
import sds.alfred.springapp.entities.bankaccount.ThirdParty;
import sds.alfred.springapp.repositories.bankaccount.AccountTypeRepository;
import sds.alfred.springapp.repositories.bankaccount.AccountingRepository;
import sds.alfred.springapp.repositories.bankaccount.BankAccountRepository;
import sds.alfred.springapp.repositories.bankaccount.BankCheckRepository;
import sds.alfred.springapp.repositories.bankaccount.EntryRepository;
import sds.alfred.springapp.repositories.bankaccount.ThirdPartyRepository;

@Service
@Transactional
public class BankAccountService {

	protected static final int NUMBER_OF_DATA_PER_PAGE = 5;
	
	@Autowired
	private AccountTypeRepository accountTypeRepository;
	@Autowired
	private AccountingRepository accountingRepository;
	@Autowired
	private BankAccountRepository bankAccountRepository;
	@Autowired
	private EntryRepository entryRepository;
	@Autowired
	private BankCheckRepository bankCheckRepository;
	@Autowired
	private ThirdPartyRepository thirdPartyRepository;
	
	public Page<Entry> findAllEntrySortByDate(){
		Sort sort = new Sort(Sort.Direction.DESC, "date" );
		Pageable pageable = new PageRequest(0, 10, sort);
		return this.entryRepository.findAll( pageable );
	}
	public ThirdParty addThirdparty( String name ){
		ThirdParty thirdParty = this.findThirdPartyByName( name );
		if( thirdParty != null )
			return thirdParty;
		thirdParty = new ThirdParty();
		thirdParty.setName( name );
		return this.thirdPartyRepository.saveAndFlush( thirdParty );
	}
	public ThirdParty findThirdPartyByName( String name ){
		return this.thirdPartyRepository.findByName( name );
	}
	public List<String> findThirdPartyByName( String name, int maxResults ){
		Pageable pageable = new PageRequest(0, maxResults );
		return this.thirdPartyRepository.findByNameLike( name, pageable );
	}
	public Entry addEntry( Entry entry ) throws Exception{
		if( entry.getBankCheck() != null ){
			BankCheck bankCheck = this.bankCheckRepository.findAvailableById( entry.getBankCheck().getId() );
			if( bankCheck == null )
				throw new Exception( "Le numéro de chèque n'existe pas." );
			bankCheck.setUsed( true );
			entry.setBankCheck( bankCheck );
		}
		return this.entryRepository.saveAndFlush( entry );
	}
	public List<BankCheck> findBankCheckAvailable(){
		return this.bankCheckRepository.findAvailable();
	}
	public List<Accounting> findAllAccounting(){
		return this.accountingRepository.findAll();
	}
	public Page<Accounting> findAllAccounting( int pageIndex){
		return this.accountingRepository.findAll( this.constructPageSpecification( pageIndex ) );
	}
	public Accounting addAccounting( Accounting accounting ){
		return this.accountingRepository.saveAndFlush(accounting);
	}
	public List<AccountType> findAllAccountType(){
		return this.accountTypeRepository.findAll();
	}
	public AccountType addAccountType( AccountType accountType ){
		return this.accountTypeRepository.saveAndFlush(accountType);
	}
	public void deleteAccountType( AccountType accountType ){
		this.accountTypeRepository.delete( accountType );
	}
	public void deleteAccountTypeById( int id ){
		this.accountTypeRepository.deleteById( id );
	}
	public void deleteBankAccountById( int id ){
		this.bankAccountRepository.deleteById( id );
	}
	public List<BankAccount> findAllBankAccount(){
		return this.bankAccountRepository.findAll();
	}
	public BankAccount addBankAccount( BankAccount bankAccount ){
		return this.bankAccountRepository.saveAndFlush( bankAccount );
	}
	public BankCheck addBankCheck( BankCheck bankCheck ){
		return this.bankCheckRepository.saveAndFlush( bankCheck );
	}
	public void deleteAccountingById( int id ){
		this.accountingRepository.deleteById( id );
	}
	public List<Entry> findAllEntries(){
		return this.entryRepository.findAll();
	}
	public void deleteBankCheckById( int id ){
		this.bankCheckRepository.deleteById(id);
	}
	public List<BankCheck> findAllBankCheck(){
		return this.bankCheckRepository.findAll();
	}
	private Pageable constructPageSpecification(int pageIndex) {
		Pageable pageSpecification = new PageRequest(pageIndex, NUMBER_OF_DATA_PER_PAGE );
		return pageSpecification;
	}
	
}
