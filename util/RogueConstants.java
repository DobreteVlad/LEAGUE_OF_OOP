package util;

public final class RogueConstants {
    private RogueConstants() {
    }
    private static final float LAND_BONUS_WOODS = 1.15f;
    private static final int INITIAL_HP_ROGUE = 600;
    private static final int BOOST_HP_ROGUE = 40;
    private static final int BASE_DAMAGE_BACKSTAB = 200;
    private static final int BOOST_DAMAGE_BACKSTAB = 20;
    private static final int BASE_DAMAGE_PARALYSIS = 40;
    private static final int BOOST_DAMAGE_PARALYSIS = 10;
    private static final float MODIFIER_BACKSTAB_KNIGHT = 0.9f;

    public static float getModifierBackstabKnight() {
        return MODIFIER_BACKSTAB_KNIGHT;
    }

    public static float getModifierBackstabPyromancer() {
        return MODIFIER_BACKSTAB_PYROMANCER;
    }

    public static float getModifierBackstabRogue() {
        return MODIFIER_BACKSTAB_ROGUE;
    }

    public static float getModifierBackstabWizard() {
        return MODIFIER_BACKSTAB_WIZARD;
    }

    public static float getModifierParalysisKnight() {
        return MODIFIER_PARALYSIS_KNIGHT;
    }

    public static float getModifierParalysisPyromancer() {
        return MODIFIER_PARALYSIS_PYROMANCER;
    }

    public static float getModifierParalysisRogue() {
        return MODIFIER_PARALYSIS_ROGUE;
    }

    public static float getModifierParalysisWizard() {
        return MODIFIER_PARALYSIS_WIZARD;
    }

    private static final float MODIFIER_BACKSTAB_PYROMANCER = 1.25f;
    private static final float MODIFIER_BACKSTAB_ROGUE = 1.2f;
    private static final float MODIFIER_BACKSTAB_WIZARD = 1.25f;
    private static final float MODIFIER_PARALYSIS_KNIGHT = 0.8f;
    private static final float MODIFIER_PARALYSIS_PYROMANCER = 1.2f;
    private static final float MODIFIER_PARALYSIS_ROGUE = 0.9f;
    private static final float MODIFIER_PARALYSIS_WIZARD = 1.25f;


    public static float getLandBonusWoods() {
        return LAND_BONUS_WOODS;
    }

    public static int getInitialHpRogue() {
        return INITIAL_HP_ROGUE;
    }

    public static int getBoostHpRogue() {
        return BOOST_HP_ROGUE;
    }

    public static int getBaseDamageBackstab() {
        return BASE_DAMAGE_BACKSTAB;
    }

    public static int getBoostDamageBackstab() {
        return BOOST_DAMAGE_BACKSTAB;
    }

    public static int getBaseDamageParalysis() {
        return BASE_DAMAGE_PARALYSIS;
    }

    public static int getBoostDamageParalysis() {
        return BOOST_DAMAGE_PARALYSIS;
    }
}
