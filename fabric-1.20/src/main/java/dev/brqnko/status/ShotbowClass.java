package dev.brqnko.status;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.Arrays;
import java.util.List;

public record ShotbowClass(String name, String informal, Item... items) {

    private static final List<ShotbowClass> CLASSES = Arrays.asList(
            new ShotbowClass("Civilian", "CIV", Items.CRAFTING_TABLE),
            new ShotbowClass("Miner", "MIN", Items.STONE_PICKAXE),
            new ShotbowClass("Archer", "ARC", Items.ARROW),
            new ShotbowClass("Warrior", "WAR", Items.STONE_SWORD),
            new ShotbowClass("Alchemist", "ALC", Items.BREWING_STAND),
            new ShotbowClass("Healer", "HEA", Items.POPPED_CHORUS_FRUIT),
            new ShotbowClass("Mercenary", "MER", Items.SKELETON_SKULL),
            new ShotbowClass("Handyman", "HAN", Items.ANVIL),
            new ShotbowClass("Scout", "SCO", Items.FISHING_ROD),
            new ShotbowClass("Acrobat", "ACR", Items.FEATHER),
            new ShotbowClass("Assassin", "ASN", Items.POTION),
            new ShotbowClass("Bard", "BAR", Items.JUKEBOX),
            new ShotbowClass("Berserker", "BER", Items.CHAINMAIL_CHESTPLATE),
            new ShotbowClass("BloodMage", "BLO", Items.FERMENTED_SPIDER_EYE),
            new ShotbowClass("Builder", "BUI", Items.BOOK),
            new ShotbowClass("Dasher", "DAS", Items.ENDER_PEARL),
            new ShotbowClass("Defender", "DEF", Items.PRISMARINE),
            new ShotbowClass("Enchanter", "ENC", Items.LAPIS_LAZULI),
            new ShotbowClass("Engineer", "ENG", Items.TNT),
            new ShotbowClass("Farmer", "FAR", Items.GOLDEN_CARROT),
            new ShotbowClass("Hunter", "HUN", Items.LEAD),
            new ShotbowClass("Iceman", "ICE", Items.ICE),
            new ShotbowClass("Immobilizer", "IMM", Items.SLIME_BALL),
            new ShotbowClass("Lumberjack", "LUM", Items.STONE_AXE),
            new ShotbowClass("Ninja", "NIN", Items.FIREWORK_STAR),
            new ShotbowClass("Pyro", "PYR", Items.FIRE_CHARGE),
            new ShotbowClass("RiftWalker", "RIF", Items.BLAZE_ROD),
            new ShotbowClass("RobinHood", "ROB", Items.SPECTRAL_ARROW),
            new ShotbowClass("Scorpio", "SCP", Items.NETHER_STAR),
            new ShotbowClass("Sniper", "SNI", Items.ARROW),
            new ShotbowClass("Spider", "SPI", Items.COBWEB),
            new ShotbowClass("Spy", "SPY", Items.SUGAR),
            new ShotbowClass("Succubus", "SUC", Items.RED_DYE),
            new ShotbowClass("Swapper", "SWA", Items.MUSIC_DISC_FAR),
            new ShotbowClass("Thor", "THO", Items.GOLDEN_AXE),
            new ShotbowClass("Tinkerer", "TIN", Items.BOOK),
            new ShotbowClass("Transporter", "TRA", Items.QUARTZ),
            new ShotbowClass("Vampire", "VAM", Items.MUSIC_DISC_BLOCKS),
            new ShotbowClass("Wizard", "WIZ", Items.STICK)
    );

    public static List<ShotbowClass> getClasses() {
        return CLASSES;
    }

    @Override
    public String toString() {
        return "ShotbowClass{" +
                "name='" + name + '\'' +
                ", informal='" + informal + '\'' +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
