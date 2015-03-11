package sds.alfred.springapp.repositories.bankaccount;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sds.alfred.springapp.entities.bankaccount.ThirdParty;

public interface ThirdPartyRepository extends JpaRepository<ThirdParty, Serializable>{

	@Query( "SELECT name FROM ThirdParty t WHERE t.name LIKE %:name%" )
	public List<String> findByNameLike(@Param("name") String name, Pageable pageable );
	
	public ThirdParty findByName( String name );
}
