package com.shootingarea.application.results;

import com.shootingarea.application.users.User;
import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int numberOfShots;
    private int maxScore;
    private int userScore;
    private float accuracy;
    private String gunType;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Result() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfShots() {
        return numberOfShots;
    }

    public void setNumberOfShots(int numberOfShots) {
        this.numberOfShots = numberOfShots;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = numberOfShots * 10;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = (userScore * 100) / maxScore;
    }

    public String getGunType() {
        return gunType;
    }

    public void setGunType(String gunType) {
        this.gunType = gunType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return numberOfShots == result.numberOfShots && maxScore == result.maxScore && userScore == result.userScore && Float.compare(result.accuracy, accuracy) == 0 && id.equals(result.id) && gunType.equals(result.gunType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfShots, maxScore, userScore, accuracy, gunType);
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", numberOfShots=" + numberOfShots +
                ", maxScore=" + maxScore +
                ", userScore=" + userScore +
                ", accuracy=" + accuracy +
                ", gunType='" + gunType +
                '}';
    }
}



