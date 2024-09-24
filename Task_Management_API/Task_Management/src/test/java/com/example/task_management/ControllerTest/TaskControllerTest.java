package com.example.task_management.ControllerTest;

import com.example.task_management.Service.TaskService;
import com.example.task_management.dto.TaskDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = Mockito.mock(TaskService.class);
    }

    @Test
    public void testCreateTask() {
        TaskDto taskDto = new TaskDto(6, "Testing Assignment", "Write Test Case for Login", "COMPLETED");
        when(taskService.createTask(any(TaskDto.class))).thenReturn(taskDto);

        ResponseEntity<TaskDto> response = restTemplate.postForEntity("/api/tasks", taskDto, TaskDto.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getTitle()).isEqualTo("Test Task");
    }

    @Test
    public void testGetAllTasks() {
        TaskDto taskDto = new TaskDto(1L, "Complete Java Assignment", "Complete the Java assignment for the Spring Boot course", "PENDING");
        List<TaskDto> tasks = Arrays.asList(taskDto);
        when(taskService.getAllTasks()).thenReturn(tasks);

        ResponseEntity<List> response = restTemplate.getForEntity("/api/tasks", List.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().size()).isEqualTo(1);
    }

    @Test
    public void testGetTaskById() {
        TaskDto taskDto = new TaskDto(1L, "Test Task", "Description", "OPEN");
        when(taskService.getTaskById(anyLong())).thenReturn(taskDto);

        ResponseEntity<TaskDto> response = restTemplate.getForEntity("/api/tasks/1", TaskDto.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getTitle()).isEqualTo("Test Task");
    }

    @Test
    public void testUpdateTask() {
        TaskDto taskDto = new TaskDto(1L, "Updated Task", "Updated Description", "IN_PROGRESS");
        when(taskService.updateTask(anyLong(), any(TaskDto.class))).thenReturn(taskDto);

        ResponseEntity<TaskDto> response = restTemplate.exchange("/api/tasks/1", HttpMethod.PUT, new HttpEntity<>(taskDto), TaskDto.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getTitle()).isEqualTo("Updated Task");
    }

    @Test
    public void testDeleteTask() {
        doNothing().when(taskService).deleteTask(anyLong());

        ResponseEntity<Void> response = restTemplate.exchange("/api/tasks/7", HttpMethod.DELETE, null, Void.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}
