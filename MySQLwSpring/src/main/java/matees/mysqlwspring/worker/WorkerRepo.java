package matees.mysqlwspring.worker;

import matees.mysqlwspring.worker.model.Worker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkerRepo extends CrudRepository<Worker, Long> {

    @Query("SELECT s FROM Worker s WHERE s.email = ?1")
    Optional<Worker> findStudentByEmail(String email);
}
