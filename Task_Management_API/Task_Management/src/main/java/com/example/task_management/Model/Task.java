package com.example.task_management.Model;


import com.example.task_management.dto.TaskDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title ;
    private String description ;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    public Task(long id, String testTask, String description, String pending)
    {
        this.id = id;
        this.title = testTask;
        this.description = description;

    }

    public void setStatus(TaskDto.TaskStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Task status cannot be null");
        }
        this.status = TaskStatus.valueOf(status.toString());
    }


}
