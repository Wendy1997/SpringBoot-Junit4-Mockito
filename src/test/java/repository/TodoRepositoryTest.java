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

    @Mock
    private TodoRepository todoRepository;

    @Before
    public void setUp(){
        // Instantiate TodoService
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllTest() throws Exception{

        // given
        todos.add(new Todo(NAME, PRIORITY));
        BDDMockito.given(todoRepository.getAll()).willReturn(new ArrayList<Todo>(todos));

        // when
        List<Todo> todoList = todoRepository.getAll();

        // then
        Assert.assertThat(todoList, org.hamcrest.Matchers.notNullValue());
    }

    @Test
    public void storeTest() throws Exception{

        // given
        BDDMockito.given(todoRepository.store(new Todo(NAME, PRIORITY))).willReturn(true);

        // when
        boolean flag = todoRepository.store(new Todo(NAME, PRIORITY));

        // then
        // Check if same
        BDDMockito.then(todoRepository).should().store(new Todo(NAME, PRIORITY));
        Assert.assertThat(flag, org.hamcrest.Matchers.equalTo(true));
    }

}
