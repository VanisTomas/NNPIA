package cz.upce.cvic.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cz.upce.cvic.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
  List<AppUser> findByActive(boolean active);

  @Query(value = "SELECT au.* FROM app_user au JOIN app_user_role aur ON au.id = aur.app_user_id JOIN role r ON aur.role_id = r.id WHERE r.name = :name", nativeQuery = true)
  List<AppUser> findByRole(@Param("name") String name);
}
