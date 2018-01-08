package controller;

import com.jayway.restassured.RestAssured;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.Introduction;
import springboot.model.Todo;
import springboot.model.constants.TodoPriority;
import springboot.service.TodoService;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Introduction.class)
public class HomeControllerTest {

    @MockBean
    private TodoService todoService;

    @LocalServerPort
    private int serverPort;

    private static final String NAME = "Todo1";
    private static final TodoPriority PRIORITY = TodoPriority.HIGH;
    private static final String TODO = "{\"code\":200,\"message\":null,"
            + "\"value\":[{\"name\":\"Todo1\",\"priority\":\"HIGH\"}]}";
    private static final String request = "{\"name\":\"Todo1\",\"priority\":\"HIGH\"}";

    @Test
    public void allTest() {
        BDDMockito.when(todoService.getAll()).thenReturn(Collections.singletonList(new Todo(NAME, PRIORITY)));

        RestAssured.given()
                .contentType("application/json")
                .when()
                .port(serverPort)
                .get("/todos")
                .then()
                .body(containsString("value"))
                .body(containsString(NAME))
                .body(equalTo(TODO))
                .statusCode(200);

        BDDMockito.verify(todoService).getAll();
    }

    @Test
    public void insertTest() {
        BDDMockito.when(todoService.saveTodo(NAME, PRIORITY)).thenReturn(true);

        RestAssured.given()
                .contentType("application/json")
                .body(request)
                .when()
                .port(serverPort)
                .post("/todos")
                .then()
                .statusCode(200);

        BDDMockito.verify(todoService).saveTodo(NAME, PRIORITY);
    }

    @After
    public void tearDown() {
        verifyNoMoreInteractions(this.todoService);
    }
}
