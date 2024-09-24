package com.example.task_management.Mapper;

import com.example.task_management.Model.Task;
import com.example.task_management.Model.TaskStatus;
import com.example.task_management.dto.TaskDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-24T00:46:58+0300",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskDto toDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDto taskDto = new TaskDto();

        taskDto.setId( task.getId() );
        taskDto.setTitle( task.getTitle() );
        taskDto.setDescription( task.getDescription() );
        taskDto.setStatus( taskStatusToTaskStatus( task.getStatus() ) );

        return taskDto;
    }

    @Override
    public Task toEntity(TaskDto taskDto) {
        if ( taskDto == null ) {
            return null;
        }

        Task task = new Task();

        task.setStatus( taskDto.getStatus() );
        task.setId( taskDto.getId() );
        task.setTitle( taskDto.getTitle() );
        task.setDescription( taskDto.getDescription() );

        return task;
    }

    protected TaskDto.TaskStatus taskStatusToTaskStatus(TaskStatus taskStatus) {
        if ( taskStatus == null ) {
            return null;
        }

        TaskDto.TaskStatus taskStatus1;

        switch ( taskStatus ) {
            case PENDING: taskStatus1 = TaskDto.TaskStatus.PENDING;
            break;
            case IN_PROGRESS: taskStatus1 = TaskDto.TaskStatus.IN_PROGRESS;
            break;
            case COMPLETED: taskStatus1 = TaskDto.TaskStatus.COMPLETED;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + taskStatus );
        }

        return taskStatus1;
    }
}
