package com.example.task_management.Service;



import com.example.task_management.dto.TaskDto;

import java.util.List;

public interface TaskService {
    TaskDto createTask(TaskDto taskDto);
    List<TaskDto> getAllTasks();
    TaskDto getTaskById(Long taskId);
    TaskDto updateTask(Long taskId ,TaskDto taskDto);
    void deleteTask(Long taskId);

}
