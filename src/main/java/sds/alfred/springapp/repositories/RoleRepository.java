package sds.alfred.springapp.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import sds.alfred.springapp.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Serializable>
{

}
