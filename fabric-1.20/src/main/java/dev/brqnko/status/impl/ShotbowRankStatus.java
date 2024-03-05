package dev.brqnko.status.impl;

import dev.brqnko.status.ShotbowRank;
import dev.brqnko.status.FetchableStatus;

public class ShotbowRankStatus extends FetchableStatus {

    private ShotbowRank rank = ShotbowRank.getRanks().get(0);

    private int currentPoint = 0;

    private double pointPercentage = 0;

    public ShotbowRank getRank() {
        return rank;
    }

    public void setRank(ShotbowRank rank) {
        this.rank = rank;
    }

    public int getCurrentPoint() {
        return currentPoint;
    }

    public void incrementCurrentPoint(int point) {
        this.setCurrentPoint(this.getCurrentPoint() + point);
    }

    public double getPointPercentage() {
        return pointPercentage;
    }

    public void setCurrentPoint(int currentPoint) {
        this.currentPoint = currentPoint;
        this.pointPercentage = (double) currentPoint / (double) this.rank.pointRequired();
    }

    @Override
    public String toString() {
        return "ShotbowRankStatus{" +
                "rank=" + rank +
                ", currentPoint=" + currentPoint +
                ", pointPercentage=" + pointPercentage +
                '}';
    }
}
