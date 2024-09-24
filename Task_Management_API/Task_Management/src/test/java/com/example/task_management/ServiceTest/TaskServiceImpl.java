package com.example.task_management.ServiceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import com.example.task_management.Mapper.TaskMapper;
import com.example.task_management.Model.Task;
import com.example.task_management.Repository.TaskRepository;
import com.example.task_management.Service.Impl.TaskServiceImpl;
import com.example.task_management.dto.TaskDto;
import com.example.task_management.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@WebMvcTest(TaskServiceImpl.class)
class TaskServiceImplTest {

    @MockBean
    private TaskRepository taskRepository;

    @Mock
    private TaskMapper taskMapper;

    @InjectMocks
    private TaskServiceImpl taskService;

    private Task task;
    private TaskDto taskDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        task = new Task(1, "Complete Java Assignment", "Complete the Java assignment for the Spring Boot course", "PENDING");
        taskDto = new TaskDto(1, "Complete Java Assignment", "Complete the Java assignment for the Spring Boot course", "PENDING");
    }

    @Test
    void testCreateTask() {
        when(taskMapper.toEntity(taskDto)).thenReturn(task);
        when(taskRepository.save(task)).thenReturn(task);
        when(taskMapper.toDto(task)).thenReturn(taskDto);

        TaskDto result = taskService.createTask(taskDto);

        assertNotNull(result);
        assertEquals(taskDto.getTitle(), result.getTitle());
        verify(taskRepository, times(1)).save(task);
        verify(taskMapper, times(1)).toDto(task);
    }

    @Test
    void testGetAllTasks() {
        List<Task> tasks = Arrays.asList(task);
        when(taskRepository.findAll()).thenReturn(tasks);
        when(taskMapper.toDto(task)).thenReturn(taskDto);

        List<TaskDto> result = taskService.getAllTasks();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(taskRepository, times(1)).findAll();
        verify(taskMapper, times(1)).toDto(task);
    }

    @Test
    void testGetTaskById() {
        when(taskRepository.findById(1l)).thenReturn(Optional.of(task));
        when(taskMapper.toDto(task)).thenReturn(taskDto);

        TaskDto result = taskService.getTaskById(1L);

        assertNotNull(result);
        assertEquals(taskDto.getTitle(), result.getTitle());
        verify(taskRepository, times(1)).findById(1L);
    }

    @Test
    void testGetTaskById_NotFound() {
        when(taskRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            taskService.getTaskById(1L);
        });
        verify(taskRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateTask() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        when(taskRepository.save(task)).thenReturn(task);
        when(taskMapper.toDto(task)).thenReturn(taskDto);

        TaskDto result = taskService.updateTask(1L, taskDto);

        assertNotNull(result);
        assertEquals(taskDto.getTitle(), result.getTitle());
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    void testDeleteTask() {
        when(taskRepository.existsById(1L)).thenReturn(true);

        taskService.deleteTask(1L);

        verify(taskRepository, times(1)).existsById(1L);
        verify(taskRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteTask_NotFound() {
        when(taskRepository.existsById(1L)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> {
            taskService.deleteTask(1L);
        });
        verify(taskRepository, times(1)).existsById(1L);
    }
}





