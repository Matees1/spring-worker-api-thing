package matees.mysqlwspring.worker;

import matees.mysqlwspring.worker.model.Worker;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    private WorkerRepo repo;

    @Autowired
    public WorkerService(WorkerRepo repo) {
        this.repo = repo;
    }

    public void addNewWorker(String name,
                             String email,
                             Integer age,
                             Role role) {

        if (repo.findStudentByEmail(email).isPresent()) {
            throw new IllegalArgumentException("The email given is already taken," +
                    " please use a different email address");
        }

        Worker newWorker = new Worker(name, email, age, role);
        repo.save(newWorker);
    }
}
