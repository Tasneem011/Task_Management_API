package com.example.task_management.Service.Impl;

import com.example.task_management.Mapper.TaskMapper;
import com.example.task_management.Model.Task;
import com.example.task_management.Repository.TaskRepository;
import com.example.task_management.Service.TaskService;
import com.example.task_management.dto.TaskDto;
import com.example.task_management.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public TaskDto createTask(TaskDto taskDto) {

        Task task = taskMapper.toEntity(taskDto);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toDto(savedTask);
    }

    @Override
    public List<TaskDto> getAllTasks() {

        return  taskRepository.findAll().stream().map(taskMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public TaskDto getTaskById(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task not found :"+taskId));
        return taskMapper.toDto(task);

    }


    @Override
    public TaskDto updateTask(Long taskId,TaskDto taskDto) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());
        return taskMapper.toDto(taskRepository.save(task));

    }

    @Override
    public void deleteTask(Long taskId) {
        if (!taskRepository.existsById(taskId)) {
            throw new ResourceNotFoundException("Task not found with id: " + taskId);
        }
        taskRepository.deleteById(taskId);
    }

}

