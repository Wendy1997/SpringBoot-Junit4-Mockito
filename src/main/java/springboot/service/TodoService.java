package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.model.Todo;
import springboot.model.constants.TodoPriority;
import springboot.repository.TodoRepository;

import java.util.List;

/**
 * Created by indra.e.prasetya on 1/18/2017.
 */
@Service
public class TodoService {

  @Autowired
  private TodoRepository todoRepository;

  public TodoService(){

  }

  public TodoService(TodoRepository todoRepository){
    this.todoRepository = todoRepository;
  }

  public boolean saveTodo(String name, TodoPriority priority) {
    Todo todo = new Todo(name, priority);

    return todoRepository.store(todo);
  }

  public List<Todo> getAll() {
    return todoRepository.getAll();
  }

}
