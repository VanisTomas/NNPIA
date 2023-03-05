package cz.upce.cvic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import cz.upce.cvic.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
