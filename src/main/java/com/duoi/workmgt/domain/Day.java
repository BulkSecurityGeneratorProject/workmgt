package com.duoi.workmgt.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "day")
public class Day {

    @Id
    @Column(name = "date")
    private LocalDate date;

    @OneToMany(mappedBy = "task" , cascade = CascadeType.ALL)
    private List<Task> tasks;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Day() {
    }

    public Day(LocalDate date, List<Task> tasks) {
        this.date = date;
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day day = (Day) o;
        return Objects.equals(date, day.date) &&
            Objects.equals(tasks, day.tasks);
    }

    @Override
    public int hashCode() {

        return Objects.hash(date, tasks);
    }

    @Override
    public String toString() {
        return "Day{" +
            "date=" + date +
            ", tasks=" + tasks +
            '}';
    }
}
