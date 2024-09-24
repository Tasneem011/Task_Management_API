package com.example.task_management.Mapper;


import com.example.task_management.Model.Task;
import com.example.task_management.dto.TaskDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDto toDto(Task task);

    Task toEntity(TaskDto taskDto);
}
