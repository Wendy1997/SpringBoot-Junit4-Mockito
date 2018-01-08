package repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import springboot.model.Todo;
import springboot.model.constants.TodoPriority;
import springboot.repository.TodoRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository Test Class
 */
public class TodoRepositoryTest {

    private static final String NAME = "Todo1";
    private static final TodoPriority PRIORITY = TodoPriority.HIGH;
    private final List<Todo> todos = new ArrayList<Todo>();
    private TodoRepository todoRepository = new TodoRepository();

    @Before
    public void setUp(){
        // Instantiate TodoService
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllTest() throws Exception{

        // when
        List<Todo> todoList = todoRepository.getAll();

        // then
        Assert.assertThat(todoList, org.hamcrest.Matchers.notNullValue());
    }

    @Test
    public void storeTest() throws Exception{

        // when
        boolean flag = todoRepository.store(new Todo(NAME, PRIORITY));

        // then
        // Check if same
        Assert.assertThat(flag, org.hamcrest.Matchers.equalTo(true));
    }

}
