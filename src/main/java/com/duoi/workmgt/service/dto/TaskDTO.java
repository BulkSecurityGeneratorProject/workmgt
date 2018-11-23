package com.duoi.workmgt.service.dto;

import com.duoi.workmgt.domain.Day;
import com.duoi.workmgt.domain.Task;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class TaskDTO {

    private long taskId;

    @DateTimeFormat
    @NotBlank
    private LocalDate taskDay;

    @NotBlank
    private String name;

    @NotBlank
    private String menager;

    private List<String> group;

    private LocalTime beginningOfTask;

    private LocalTime endOfTask;

    public TaskDTO() {
    }

    public TaskDTO(Task task) {
        this.taskId = task.getTaskId();
        this.taskDay = task.getTaskDay().getDate();
        this.name = task.getName();
        this.menager = task.getMenager().toString();
        this.group = task.getGroup().stream()
            .map(u -> (u.getFirstName() + " " + u.getLastName()))
            .collect(Collectors.toList());
        this.beginningOfTask = beginningOfTask;
        this.endOfTask = endOfTask;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public LocalDate getTaskDay() {
        return taskDay;
    }

    public void setTaskDay(LocalDate taskDay) {
        this.taskDay = taskDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenager() {
        return menager;
    }

    public void setMenager(String menager) {
        this.menager = menager;
    }

    public List<String> getGroup() {
        return group;
    }

    public void setGroup(List<String> group) {
        this.group = group;
    }

    public LocalTime getBeginningOfTask() {
        return beginningOfTask;
    }

    public void setBeginningOfTask(LocalTime beginningOfTask) {
        this.beginningOfTask = beginningOfTask;
    }

    public LocalTime getEndOfTask() {
        return endOfTask;
    }

    public void setEndOfTask(LocalTime endOfTask) {
        this.endOfTask = endOfTask;
    }
}
