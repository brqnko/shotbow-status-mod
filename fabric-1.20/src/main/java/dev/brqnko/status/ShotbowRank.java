package dev.brqnko.status;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public record ShotbowRank(String tag, int pointRequired, int color) {

    private static final List<ShotbowRank> RANKS = Arrays.asList(
            new ShotbowRank("Unranked", 250, Color.WHITE.getRGB()),
            new ShotbowRank("Novice-I", 500, Color.GREEN.getRGB()),
            new ShotbowRank("Novice-II", 1000, Color.GREEN.getRGB()),
            new ShotbowRank("Novice-III", 2000, Color.GREEN.getRGB()),
            new ShotbowRank("Silver-I", 5000, Color.GRAY.getRGB()),
            new ShotbowRank("Silver-II", 10000, Color.GRAY.getRGB()),
            new ShotbowRank("Silver-III", 20000, Color.GRAY.getRGB()),
            new ShotbowRank("Gold-I", 30000, Color.YELLOW.getRGB()),
            new ShotbowRank("Gold-II", 40000, Color.YELLOW.getRGB()),
            new ShotbowRank("Gold-III", 50000, Color.YELLOW.getRGB()),
            new ShotbowRank("Master-I", 75000, Color.RED.getRGB()),
            new ShotbowRank("Master-II", 125000, Color.RED.getRGB()),
            new ShotbowRank("Master-III", 250000, Color.RED.getRGB()),
            new ShotbowRank("GrandMaster-I", 500000, Color.MAGENTA.getRGB()),
            new ShotbowRank("GrandMaster-II", 750000, Color.MAGENTA.getRGB()),
            new ShotbowRank("GrandMaster-III", 1000000, Color.MAGENTA.getRGB()),
            new ShotbowRank("Annihilator", -1, Color.BLACK.getRGB())
    );

    public static List<ShotbowRank> getRanks() {
        return RANKS;
    }

    public static ShotbowRank fromTag(String tag) {
        return RANKS.stream()
                .filter(shotbowRank -> shotbowRank.tag.equalsIgnoreCase(tag))
                .findAny()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "ShotbowRank{" +
                "tag='" + tag + '\'' +
                ", pointRequired=" + pointRequired +
                '}';
    }
}
