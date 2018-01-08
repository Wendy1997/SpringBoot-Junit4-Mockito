package springboot.repository;

import org.springframework.stereotype.Service;
import springboot.model.Todo;
import springboot.model.constants.TodoPriority;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by indra.e.prasetya on 1/18/2017.
 */
@Service
public class TodoRepository {

  private final List<Todo> todos = new ArrayList<Todo>();

  public boolean store(Todo todo) {
    todos.add(todo);
    return true;
  }

  public List<Todo> getAll() {
    return new ArrayList<Todo>(todos);
  }
}
