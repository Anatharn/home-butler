package sds.alfred.springapp.repositories.bankaccount;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sds.alfred.springapp.entities.bankaccount.Entry;

public interface EntryRepository extends JpaRepository<Entry, Serializable> {

	public List<Entry> findAll();
}
