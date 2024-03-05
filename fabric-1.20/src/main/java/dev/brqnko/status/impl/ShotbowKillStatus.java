package dev.brqnko.status.impl;

public class ShotbowKillStatus {

    private int swordKillCount;
    private int bowKillCount;
    private int nexusCount;

    public void resetSwordKillCount() {
        this.swordKillCount = 0;
    }

    public void resetBowKillCount() {
        this.bowKillCount = 0;
    }

    public void resetNexusCount() {
        this.nexusCount = 0;
    }

    public void incrementSwordKillCount() {
        this.swordKillCount++;
    }

    public void incrementBowKillCount() {
        this.bowKillCount++;
    }

    public void incrementNexusCount() {
        this.nexusCount++;
    }

    public int getSwordKillCount() {
        return swordKillCount;
    }

    public int getBowKillCount() {
        return bowKillCount;
    }

    public int getNexusCount() {
        return nexusCount;
    }

    @Override
    public String toString() {
        return "ShotbowKillStatus{" +
                "swordKillCount=" + swordKillCount +
                ", bowKillCount=" + bowKillCount +
                ", nexusCount=" + nexusCount +
                '}';
    }
}
