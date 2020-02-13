package util;

public final class KnightConstants {
    private KnightConstants() {
    }
    private static final float LAND_BONUS_LAND = 1.15f;
    private static final int INITIAL_HP_KNIGHT = 900;
    private static final int BOOST_HP_KNIGHT = 80;
    private static final int BASE_DAMAGE_EXECUTE = 200;
    private static final int BOOST_DAMAGE_EXECUTE = 30;
    private static final int BASE_DAMAGE_SLAM = 100;
    private static final int BOOST_DAMAGE_SLAM = 40;
    public static float getLandBonusLand() {
        return LAND_BONUS_LAND;
    }

    public static int getInitialHpKnight() {
        return INITIAL_HP_KNIGHT;
    }

    public static int getBoostHpKnight() {
        return BOOST_HP_KNIGHT;
    }

    public static int getBaseDamageExecute() {
        return BASE_DAMAGE_EXECUTE;
    }

    public static int getBoostDamageExecute() {
        return BOOST_DAMAGE_EXECUTE;
    }

    public static int getBaseDamageSlam() {
        return BASE_DAMAGE_SLAM;
    }

    public static int getBoostDamageSlam() {
        return BOOST_DAMAGE_SLAM;
    }

    private static final float MODIFIER_EXECUTE_PYROMANCER = 1.1f;
    private static final float MODIFIER_EXECUTE_ROGUE = 1.15f;
    private static final float MODIFIER_EXECUTE_WIZARD = 0.8f;
    private static final float MODIFIER_SLAM_KNIGHT = 1.2f;
    private static final float MODIFIER_SLAM_PYROMANCER = 0.9f;
    private static final float MODIFIER_SLAM_ROGUE = 0.8f;
    private static final float MODIFIER_SLAM_WIZARD = 1.05f;

    public static float getModifierExecutePyromancer() {
        return MODIFIER_EXECUTE_PYROMANCER;
    }

    public static float getModifierExecuteRogue() {
        return MODIFIER_EXECUTE_ROGUE;
    }

    public static float getModifierExecuteWizard() {
        return MODIFIER_EXECUTE_WIZARD;
    }

    public static float getModifierSlamKnight() {
        return MODIFIER_SLAM_KNIGHT;
    }

    public static float getModifierSlamPyromancer() {
        return MODIFIER_SLAM_PYROMANCER;
    }

    public static float getModifierSlamRogue() {
        return MODIFIER_SLAM_ROGUE;
    }

    public static float getModifierSlamWizard() {
        return MODIFIER_SLAM_WIZARD;
    }
}
