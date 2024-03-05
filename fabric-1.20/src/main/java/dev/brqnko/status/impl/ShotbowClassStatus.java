package dev.brqnko.status.impl;

import dev.brqnko.status.ShotbowClass;
import net.minecraft.item.Item;

import java.util.Arrays;

public class ShotbowClassStatus {

    private ShotbowClass currentClass = ShotbowClass.getClasses().get(0);

    private boolean classInitialized = false;

    private boolean[] isInCooldow;
    private long[] cooldownStartTimeMs;

    private int[] cooldownLength;

    public void setReady(Item item) {
        if (!classInitialized) {
            return;
        }

        for (int i = 0; i < currentClass.items().length; i++) {
            Item currentItem = currentClass.items()[i];

            if (currentItem != item) {
                continue;
            }

            this.isInCooldow[i] = false;
        }
    }

    public void setCooldown(Item item, int cooldown) {
        if (!classInitialized) {
            return;
        }

        for (int i = 0; i < currentClass.items().length; i++) {
            Item currentItem = currentClass.items()[i];

            if (currentItem != item) {
                continue;
            }

            if (this.isInCooldow[i]) {
                return;
            }

            this.isInCooldow[i] = true;
            this.cooldownLength[i] = cooldown;
            this.cooldownStartTimeMs[i] = System.currentTimeMillis();
        }
    }

    public boolean isReady(Item item) {
        if (!classInitialized) {
            return false;
        }

        for (int i = 0; i < currentClass.items().length; i++) {
            Item currentItem = currentClass.items()[i];

            if (currentItem != item) {
                continue;
            }

            return this.isInCooldow[i];
        }

        return false;
    }

    public double getCTPercentage(Item item) {
        if (!classInitialized) {
            return 1;
        }

        for (int i = 0; i < currentClass.items().length; i++) {
            Item currentItem = currentClass.items()[i];

            if (currentItem != item) {
                continue;
            }

            if (!isInCooldow[i]) {
                return 1;
            }

            long startTimeMs = this.cooldownStartTimeMs[i];
            int cooldownLength = this.cooldownLength[i];

            return Math.min((System.currentTimeMillis() - startTimeMs) / (double) cooldownLength / 1000, 1);
        }

        return 0;
    }

    public ShotbowClass getCurrentClass() {
        return currentClass;
    }

    public void setCurrentClass(ShotbowClass currentClass) {
        this.classInitialized = true;

        this.currentClass = currentClass;

        int itemsLength = currentClass.items().length;

        this.isInCooldow = new boolean[itemsLength];
        this.cooldownStartTimeMs = new long[itemsLength];
        this.cooldownLength = new int[itemsLength];
    }

    @Override
    public String toString() {
        return "ShotbowClassStatus{" +
                "currentClass=" + currentClass +
                ", classInitialized=" + classInitialized +
                ", isInCooldow=" + Arrays.toString(isInCooldow) +
                ", cooldownStartTimeMs=" + Arrays.toString(cooldownStartTimeMs) +
                ", cooldownLength=" + Arrays.toString(cooldownLength) +
                '}';
    }
}
