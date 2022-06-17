package com.george.wallet_desktop.model;

public class Goal {
    String name;
    int goalPrice;
    int defaultPrice;
    String dateGoal;
    String color;

    public Goal(String name, int goalPrice, int defaultPrice, String dareGoal, String color) {
        this.name = name;
        this.goalPrice = goalPrice;
        this.defaultPrice = defaultPrice;
        this.dateGoal = dareGoal;
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

    public String getDateGoal() {
        return dateGoal;
    }

    public String getColor() {
        return color;
    }
}
