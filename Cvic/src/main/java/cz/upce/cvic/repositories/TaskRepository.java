package cz.upce.cvic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import cz.upce.cvic.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
