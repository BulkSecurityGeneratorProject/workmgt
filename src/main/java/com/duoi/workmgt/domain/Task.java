package com.duoi.workmgt.domain;

import org.joda.time.LocalTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "task")
public class Task{

    @Column(name = "taskId")
    @GeneratedValue
    private long taskId;

    @ManyToOne
    @JoinColumn(name = "date")
    private Day taskDay;

    @NotNull
    @Column(name = "task_name")
    private String name;

    @NotNull
    @Column(name = "menager")
    private User menager;

    @OneToMany(mappedBy = "user")
    @Column
    private List<User> group;

    @Column
    private LocalTime beginningOfTask;

    @Column
    private LocalTime endOfTask;

    public Task(){

    }

    public Task(Day taskDay, @NotNull String name, @NotNull User menager, @NotNull List<User> group, LocalTime beginningOfTask, LocalTime endOfTask) {
        this.taskDay = taskDay;
        this.name = name;
        this.menager = menager;
        this.group = group;
        this.beginningOfTask = beginningOfTask;
        this.endOfTask = endOfTask;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public Day getTaskDay() {
        return this.getTaskDay();
    }

    public void setTaskDay(Day taskDay) {
        this.taskDay = taskDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getMenager() {
        return menager;
    }

    public void setMenager(User menager) {
        this.menager = menager;
    }

    public List<User> getGroup() {
        return group;
    }

    public void setGroup(List<User> group) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return taskId == task.taskId &&
            Objects.equals(taskDay, task.taskDay) &&
            Objects.equals(name, task.name) &&
            Objects.equals(menager, task.menager) &&
            Objects.equals(group, task.group) &&
            Objects.equals(beginningOfTask, task.beginningOfTask) &&
            Objects.equals(endOfTask, task.endOfTask);
    }

    @Override
    public int hashCode() {

        return Objects.hash(taskId, taskDay, name, menager, group, beginningOfTask, endOfTask);
    }

    @Override
    public String toString() {
        return "Task{" +
            "taskId=" + taskId +
            ", taskDay=" + taskDay +
            ", name='" + name + '\'' +
            ", menager=" + menager +
            ", group=" + group +
            ", beginningOfTask=" + beginningOfTask +
            ", endOfTask=" + endOfTask +
            '}';
    }
}
