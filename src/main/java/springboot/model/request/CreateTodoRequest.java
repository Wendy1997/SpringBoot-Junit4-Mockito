package springboot.model.request;

import springboot.model.constants.TodoPriority;

import javax.validation.constraints.NotNull;

/**
 * Created by indra.e.prasetya on 1/18/2017.
 */
public class CreateTodoRequest {
  private String name;
  private TodoPriority priority;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TodoPriority getPriority() {
    return priority;
  }

  public void setPriority(TodoPriority priority) {
    this.priority = priority;
  }
}
