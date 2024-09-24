package com.example.task_management.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;

    public TaskDto(long id, String testTask, String description, String pending) {
        this.id = id;
        this.title = testTask;
    }


    public enum TaskStatus {
        PENDING,
        IN_PROGRESS,
        COMPLETED
    }
}
