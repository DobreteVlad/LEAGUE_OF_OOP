package util;

public final class LifeGiverConstants {
    private LifeGiverConstants() {
    }
    private static final int BONUS_HP_KNIGHT = 100;
    private static final int BONUS_HP_PYROMANCER = 80;
    private static final int BONUS_HP_ROGUE = 90;
    private static final int BONUS_HP_WIZARD = 120;

    public static int getBonusHpKnight() {
        return BONUS_HP_KNIGHT;
    }

    public static int getBonusHpPyromancer() {
        return BONUS_HP_PYROMANCER;
    }

    public static int getBonusHpRogue() {
        return BONUS_HP_ROGUE;
    }

    public static int getBonusHpWizard() {
        return BONUS_HP_WIZARD;
    }
}
