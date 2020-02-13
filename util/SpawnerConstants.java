package util;


public final class SpawnerConstants {
    private SpawnerConstants() {
    }
    private static final int NEW_HP_KNIGHT = 200;
    private static final int NEW_HP_PYROMANCER = 150;
    private static final int NEW_HP_ROGUE = 180;
    private static final int NEW_HP_WIZARD = 120;

    public static int getNewHpKnight() {
        return NEW_HP_KNIGHT;
    }

    public static int getNewHpPyromancer() {
        return NEW_HP_PYROMANCER;
    }

    public static int getNewHpRogue() {
        return NEW_HP_ROGUE;
    }

    public static int getNewHpWizard() {
        return NEW_HP_WIZARD;
    }
}
