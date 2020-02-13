package util;

public final class DraculaConstants {
    private DraculaConstants() {
    }

    private static final float DECREASE_DAMAGE_KNIGHT = 0.2f;
    private static final float DECREASE_DAMAGE_PYROMANCER = 0.3f;
    private static final float DECREASE_DAMAGE_ROGUE = 0.1f;
    private static final float DECREASE_DAMAGE_WIZARD = 0.4f;
    private static final int DECREASE_HP_KNIGHT = 60;
    private static final int DECREASE_HP_PYROMANCER = 40;
    private static final int DECREASE_HP_ROGUE = 35;

    public static int getDecreaseHpKnight() {
        return DECREASE_HP_KNIGHT;
    }

    public static int getDecreaseHpPyromancer() {
        return DECREASE_HP_PYROMANCER;
    }

    public static int getDecreaseHpRogue() {
        return DECREASE_HP_ROGUE;
    }

    public static int getDecreaseHpWizard() {
        return DECREASE_HP_WIZARD;
    }

    private static final int DECREASE_HP_WIZARD = 20;

    public static float getDecreaseDamagePyromancer() {
        return DECREASE_DAMAGE_PYROMANCER;
    }

    public static float getDecreaseDamageRogue() {
        return DECREASE_DAMAGE_ROGUE;
    }

    public static float getDecreaseDamageWizard() {
        return DECREASE_DAMAGE_WIZARD;
    }

    public static float getDecreaseDamageKnight() {
        return DECREASE_DAMAGE_KNIGHT;
    }
}
