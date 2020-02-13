package util;

public final class LevelUpAngelConstants {
    private LevelUpAngelConstants() {
    }

    private static final float BONUS_DAMAGE_KNIGHT = 0.1f;
    private static final float BONUS_DAMAGE_PYROMANCER = 0.2f;
    private static final float BONUS_DAMAGE_ROGUE = 0.15f;
    private static final float BONUS_DAMAGE_WIZARD = 0.25f;

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
