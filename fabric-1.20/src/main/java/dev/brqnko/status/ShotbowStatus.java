package dev.brqnko.status;

import dev.brqnko.status.impl.ShotbowKillStatus;
import dev.brqnko.status.impl.ShotbowClassStatus;
import dev.brqnko.status.impl.ShotbowRankStatus;

public record ShotbowStatus(ShotbowKillStatus killStatus, ShotbowRankStatus rankStatus, ShotbowClassStatus classStatus) {

    private static final ShotbowStatus SINGLETON = new ShotbowStatus(
            new ShotbowKillStatus(),
            new ShotbowRankStatus(),
            new ShotbowClassStatus()
    );

    public static ShotbowStatus getInstance() {
        return SINGLETON;
    }

    @Override
    public String toString() {
        return "ShotbowStatus{" +
                "killStatus=" + killStatus +
                ", rankStatus=" + rankStatus +
                ", classStatus=" + classStatus +
                '}';
    }
}
