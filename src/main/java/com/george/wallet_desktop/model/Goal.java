package com.george.wallet_desktop.model;

public class Goal {
    String name;
    int goalPrice;
    int defaultPrice;
    String dareGoal;
    String color;

    public Goal(String name, int goalPrice, int defaultPrice, String dareGoal, String color) {
        this.name = name;
        this.goalPrice = goalPrice;
        this.defaultPrice = defaultPrice;
        this.dareGoal = dareGoal;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getGoalPrice() {
        return goalPrice;
    }

    public int getDefaultPrice() {
        return defaultPrice;
    }

    public String getDareGoal() {
        return dareGoal;
    }

    public String getColor() {
        return color;
    }
}
