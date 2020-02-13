package util;

public final class AtackConstants {
    private AtackConstants() {
    }
    private static final float BONUS_DAMAGE_KNIGHT = 0.5f;
    private static final float BONUS_DAMAGE_PYROMANCER = 0.7f;
    private static final float BONUS_DAMAGE_ROGUE = 0.4f;
    private static final float BONUS_DAMAGE_WIZARD = 0.6f;

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
