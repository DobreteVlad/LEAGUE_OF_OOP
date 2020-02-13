package util;

public final class DefenseConstants {
    private DefenseConstants() {
    }
    private static final float BONUS_DAMAGE_KNIGHT = 0.2f;
    private static final float BONUS_DAMAGE_PYROMANCER = 0.3f;
    private static final float BONUS_DAMAGE_ROGUE = 0.1f;
    private static final float BONUS_DAMAGE_WIZARD = 0.2f;

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
