package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.model.response.ResponseWrapper;
import springboot.model.Todo;
import springboot.model.request.CreateTodoRequest;
import springboot.service.TodoService;

import java.util.List;

/**
 * Created by indra.e.prasetya on 1/18/2017.
 */
@RestController
@RequestMapping("/todos")
public class HomeController {

  @Autowired
  private TodoService todoService;

  @GetMapping
  public ResponseWrapper<List<Todo>> all() {
    ResponseWrapper<List<Todo>> resp = new ResponseWrapper<List<Todo>>();
    resp.setValue(todoService.getAll());

    return resp;
  }

  @PostMapping
  public ResponseWrapper<Boolean> insert(@RequestBody CreateTodoRequest request) {
    boolean success = todoService.saveTodo(request.getName(), request.getPriority());

    ResponseWrapper<Boolean> resp = new ResponseWrapper<Boolean>();
    resp.setValue(success);

    return resp;
  }


}
