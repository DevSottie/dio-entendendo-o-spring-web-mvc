package dio.tutorials.springwebmvc.repository;

import dio.tutorials.springwebmvc.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository //diz ao spring que essa classe sera gerenciada por ele como um repository
public class JediRepository {
    private List<Jedi> jedi;

    public JediRepository() {
        jedi = new ArrayList<>();
        jedi.add(new Jedi("Luke", "Skywalker"));
    }

    public List<Jedi> getAllJedi(){
        return this.jedi;
    }

    public void add(Jedi jedi) {
        this.jedi.add(jedi);
    }
}
