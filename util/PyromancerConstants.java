package util;

public final class PyromancerConstants {
    private PyromancerConstants() {
    }
    private static final float LAND_BONUS_VOLCANO = 1.25f;
    private static final int INITIAL_HP_PYROMANCER = 500;
    private static final int BOOST_HP_PYROMANCER = 50;
    private static final int BASE_DAMAGE_FIREBLAST = 350;
    private static final int BOOST_DAMAGE_FIREBLAST = 50;
    private static final int BASE_DAMAGE_IGNITE = 150;
    private static final int BOOST_DAMAGE_IGNITE = 20;
    private static final int OVERTIME_DAMAGE_IGNITE = 50;
    private static final int BOOST_OVERTIME_DAMAGE_IGNITE = 30;

    public static float getLandBonusVolcano() {
        return LAND_BONUS_VOLCANO;
    }

    public static int getInitialHpPyromancer() {
        return INITIAL_HP_PYROMANCER;
    }

    public static int getBoostHpPyromancer() {
        return BOOST_HP_PYROMANCER;
    }

    public static int getBaseDamageFireblast() {
        return BASE_DAMAGE_FIREBLAST;
    }

    public static int getBoostDamageFireblast() {
        return BOOST_DAMAGE_FIREBLAST;
    }

    public static int getBaseDamageIgnite() {
        return BASE_DAMAGE_IGNITE;
    }

    public static int getBoostDamageIgnite() {
        return BOOST_DAMAGE_IGNITE;
    }

    public static int getOvertimeDamageIgnite() {
        return OVERTIME_DAMAGE_IGNITE;
    }

    public static int getBoostOvertimeDamageIgnite() {
        return BOOST_OVERTIME_DAMAGE_IGNITE;
    }
    private static final float MODIFIER_FIREBLAST_PYROMANCER = 0.9f;
    private static final float MODIFIER_FIREBLAST_ROGUE = 0.8f;
    private static final float MODIFIER_FIREBLAST_WIZARD = 1.05f;
    private static final float MODIFIER_FIREBLAST_KNIGHT = 1.2f;
    private static final float MODIFIER_IGNITE_KNIGHT = 1.2f;
    private static final float MODIFIER_IGNITE_PYROMANCER = 0.9f;
    private static final float MODIFIER_IGNITE_ROGUE = 0.8f;

    public static float getModifierFireblastPyromancer() {
        return MODIFIER_FIREBLAST_PYROMANCER;
    }

    public static float getModifierFireblastRogue() {
        return MODIFIER_FIREBLAST_ROGUE;
    }

    public static float getModifierFireblastWizard() {
        return MODIFIER_FIREBLAST_WIZARD;
    }

    public static float getModifierFireblastKnight() {
        return MODIFIER_FIREBLAST_KNIGHT;
    }

    public static float getModifierIgniteKnight() {
        return MODIFIER_IGNITE_KNIGHT;
    }

    public static float getModifierIgnitePyromancer() {
        return MODIFIER_IGNITE_PYROMANCER;
    }

    public static float getModifierIgniteRogue() {
        return MODIFIER_IGNITE_ROGUE;
    }

    public static float getModifierIgniteWizard() {
        return MODIFIER_IGNITE_WIZARD;
    }

    private static final float MODIFIER_IGNITE_WIZARD = 1.05f;
}
