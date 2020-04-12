package utils;

import domain.TodoItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HTTPUtilsTest {

    HTTPUtils httpUtils;
    JsonToObjectParser parser;

    @BeforeEach
    void setup() {
        httpUtils = new HTTPUtils();
        parser = new JsonToObjectParser();
    }

    @Test
    void getTodoItemJsonString() throws IOException {
        String result = httpUtils.getTodoItemJsonString(1);
        TodoItem item = parser.JsonStringToOneObject(result);
        assertEquals(1, item.getId());
    }

    @Test
    void addTodoItem() throws IOException {
        var result = httpUtils.addTodoItem("Add todo test", "Friday");
        TodoItem expected = parser.JsonStringToOneObject(result);
        var actual = httpUtils.getTodoItemJsonString(expected.getId());

    }

    @Test
    void deleteTodoItem() throws IOException {
        var result = httpUtils.addTodoItem("Delete tests", "Friday");
        TodoItem item = parser.JsonStringToOneObject(result);
        var deletedResult = httpUtils.deleteTodoItem(item.getId());
        assertTrue(deletedResult);
    }


    @Test
    void deleteTodoItem_InvalidID() throws IOException {
        var deletedResult = httpUtils.deleteTodoItem(100000);
        assertFalse(deletedResult);
    }

    @Test
    void completeTodoItem() throws IOException {
        var result = httpUtils.addTodoItem("Complete item", "Friday");
        TodoItem item = parser.JsonStringToOneObject(result);
        assertEquals("false", item.getCompleted());
        var updatedResult = httpUtils.completeTodoItem(item);
        assertTrue(updatedResult);
    }


}