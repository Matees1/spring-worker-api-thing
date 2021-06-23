package matees.mysqlwspring.worker;

import matees.mysqlwspring.worker.model.Worker;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api/worker")
public class WorkerController {

    @Autowired
    private WorkerRepo repo;

    @GetMapping
    public @ResponseBody
    Iterable<Worker> getAllWorkers() {
        return repo.findAll();
    }
}
