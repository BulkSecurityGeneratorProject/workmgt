package com.duoi.workmgt.service.dto;

import com.duoi.workmgt.domain.Day;
import com.duoi.workmgt.domain.Task;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DayDTO {

    @DateTimeFormat
    private LocalDate date;

    private List<String> tasks;

    public DayDTO() {
    }

    public DayDTO(Day day) {
        this.date = day.getDate();
        this.tasks = day.getTasks().stream()
            .map(Task::getName)
            .collect(Collectors.toList());
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTasks() {
        return tasks.toString();
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "DayDTO{" +
            "date=" + date +
            ", tasks=" + tasks +
            '}';
    }
}
