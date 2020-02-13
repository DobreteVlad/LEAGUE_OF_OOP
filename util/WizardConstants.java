package util;

public final class WizardConstants {
    private WizardConstants() {
    }
    private static final float LAND_BONUS_DESERT = 1.1f;
    private static final int INITIAL_HP_WIZARD = 400;
    private static final int BOOST_HP_WIZARD = 30;
    private static final float BASE_DAMAGE_DRAIN = 0.2f;
    private static final float BOOST_DAMAGE_DRAIN = 0.05f;
    private static final float BASE_DAMAGE_DEFLECT = 0.35f;
    private static final float BOOST_DAMAGE_DEFLECT = 0.02f;

    public static float getLandBonusDesert() {
        return LAND_BONUS_DESERT;
    }

    public static int getInitialHpWizard() {
        return INITIAL_HP_WIZARD;
    }

    public static int getBoostHpWizard() {
        return BOOST_HP_WIZARD;
    }

    public static float getBaseDamageDrain() {
        return BASE_DAMAGE_DRAIN;
    }

    public static float getBoostDamageDrain() {
        return BOOST_DAMAGE_DRAIN;
    }

    public static float getBaseDamageDeflect() {
        return BASE_DAMAGE_DEFLECT;
    }

    public static float getBoostDamageDeflect() {
        return BOOST_DAMAGE_DEFLECT;
    }
    private static final float MODIFIER_DRAIN_PYROMANCER = 0.9f;
    private static final float MODIFIER_DRAIN_ROGUE = 0.8f;
    private static final float MODIFIER_DRAIN_WIZARD = 1.05f;
    private static final float MODIFIER_DRAIN_KNIGHT = 1.2f;
    private static final float MODIFIER_DEFLECT_PYROMANCER = 1.3f;
    private static final float MODIFIER_DEFLECT_ROGUE = 1.2f;
    private static final float MODIFIER_DEFLECT_KNIGHT = 1.4f;

    public static float getModifierDrainPyromancer() {
        return MODIFIER_DRAIN_PYROMANCER;
    }

    public static float getModifierDrainRogue() {
        return MODIFIER_DRAIN_ROGUE;
    }

    public static float getModifierDrainWizard() {
        return MODIFIER_DRAIN_WIZARD;
    }

    public static float getModifierDrainKnight() {
        return MODIFIER_DRAIN_KNIGHT;
    }

    public static float getModifierDeflectPyromancer() {
        return MODIFIER_DEFLECT_PYROMANCER;
    }

    public static float getModifierDeflectRogue() {
        return MODIFIER_DEFLECT_ROGUE;
    }

    public static float getModifierDeflectKnight() {
        return MODIFIER_DEFLECT_KNIGHT;
    }
}
