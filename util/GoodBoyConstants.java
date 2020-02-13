package util;

public final class GoodBoyConstants {
    private GoodBoyConstants() {
    }

    private static final float BONUS_DAMAGE_KNIGHT = 0.4f;
    private static final float BONUS_DAMAGE_PYROMANCER = 0.5f;
    private static final float BONUS_DAMAGE_ROGUE = 0.4f;
    private static final float BONUS_DAMAGE_WIZARD = 0.3f;
    private static final int BONUS_HP_KNIGHT = 20;
    private static final int BONUS_HP_PYROMANCER = 30;
    private static final int BONUS_HP_ROGUE = 40;
    private static final int BONUS_HP_WIZARD = 50;

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

    public static float getBonusDamageKnight() {
        return BONUS_DAMAGE_KNIGHT;
    }

    public static float getBonusDamagePyromancer() {
        return BONUS_DAMAGE_PYROMANCER;
    }

    public static float getBonusDamageRogue() {
        return BONUS_DAMAGE_ROGUE;
    }

    public static float getBonusDamageWizard() {
        return BONUS_DAMAGE_WIZARD;
    }
}
