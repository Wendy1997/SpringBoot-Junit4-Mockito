package service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import springboot.model.Todo;
import springboot.model.constants.TodoPriority;
import springboot.repository.TodoRepository;
import springboot.service.TodoService;

import java.util.ArrayList;
import java.util.List;


/**
 * Test Class
 */
public class TodoServiceTest {

    private static final String NAME = "Todo1";
    private static final TodoPriority PRIORITY = TodoPriority.HIGH;
    private TodoService todoService;

    @Mock
    private TodoRepository todoRepository;

    @Before
    public void setUp(){
        // Instantiate TodoService
        MockitoAnnotations.initMocks(this);
        this.todoService = new TodoService(this.todoRepository);
    }

    @After
    public void tearDown(){
        Mockito.verifyNoMoreInteractions(todoRepository);
    }

    @Test
    public void getAllTest() throws Exception{

        // given
        ArrayList<Todo> todos = new ArrayList<Todo>();
        todos.add(new Todo(NAME, PRIORITY));
        BDDMockito.given(todoRepository.getAll()).willReturn(todos);

        // when
        List<Todo> todoList = todoService.getAll();

        // then
        // Check if null
        Assert.assertThat(todoList, org.hamcrest.Matchers.notNullValue());
        // Check if empty
        Assert.assertThat(todoList.isEmpty(), org.hamcrest.Matchers.equalTo(false));
        // verify
        // verify jalanin getAll
        BDDMockito.then(todoRepository).should().getAll();
    }

    @Test
    public void saveTodoTest() throws Exception{

        // given
        BDDMockito.given(todoRepository.store(new Todo(NAME, PRIORITY))).willReturn(true);

        // when
        boolean flag = todoService.saveTodo(NAME, PRIORITY);

        // then
        // Check if same
        BDDMockito.then(todoRepository).should().store(new Todo(NAME, PRIORITY));
        Assert.assertThat(flag, org.hamcrest.Matchers.equalTo(true));

    }

}
