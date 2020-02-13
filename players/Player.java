package players;

import angels.Angel;
import main.Observator;

import java.util.ArrayList;

public abstract class Player {
    private int hp;
    private int xp;
    private int level;
    private int damageFirstAbility;
    private int damageSecondAbility;
    private char name;
    private int x;
    private int y;
    private boolean roundDamageIndicator;
    private int numberRoundsDamage;
    private int damageOvertime;
    private int maxHp;
    private boolean incapacityMove;
    private float damageTotalNoRace;
    private int backstabNumberhits;
    private boolean bigOvertime;
    private int deadFromOvertime;
    private boolean noEnter;
    private String fullName;
    private int numberOfPlayer;
    ArrayList<Observator> observer = new ArrayList<>();

    public final void setNumberOfPlayer(final int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    public final int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public final void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public final String getFullName() {
        return fullName;
    }

    public final void addHp(final int hpp) {
        this.hp += hpp;
    }

    /**
     * @param noEnterr
     */
    public void setnoEnter(final boolean noEnterr) {
        this.noEnter = noEnterr;
    }

    /**
     * @return
     */
    public boolean isnoEnter() {
        return noEnter;
    }

    /**
     * @param deadFromOvertimee
     */
    public void setdeadFromOvertime(final int deadFromOvertimee) {
        this.deadFromOvertime = deadFromOvertimee;
    }

    /**
     * @return
     */
    public int getdeadFromOvertime() {
        return deadFromOvertime;
    }

    /**
     * @param bigOvertimee
     */
    public void setbigOvertime(final boolean bigOvertimee) {
        this.bigOvertime = bigOvertimee;
    }

    /**
     * @return
     */
    public boolean isbigOvertime() {
        return bigOvertime;
    }

    /**
     * @param backstabNumberhitss
     */
    public void setBackstabNumberhits(final int backstabNumberhitss) {
        backstabNumberhits = backstabNumberhitss;
    }

    /**
     * @return
     */
    public int getBackstabNumberhits() {
        return backstabNumberhits;
    }

    /**
     * @param damageTotalNoRacee
     */
    public void setdamageTotalNoRace(final float damageTotalNoRacee) {
        damageTotalNoRace = damageTotalNoRacee;
    }

    /**
     * @return
     */
    public float getdamageTotalNoRace() {
        return damageTotalNoRace;
    }

    /**
     * @param damageTotalNoRacee
     */
    public void modifyDamageTotalNoRace(final float damageTotalNoRacee) {
        this.damageTotalNoRace += damageTotalNoRacee;
    }

    /**
     * @param incapacityMovee
     */
    public void setincapacityMove(final boolean incapacityMovee) {
        this.incapacityMove = incapacityMovee;
    }

    /**
     * @return
     */
    public boolean isincapacityMove() {
        return incapacityMove;
    }

    /**
     * @param maxHpp
     */
    public void setmaxHp(final int maxHpp) {
        this.maxHp = maxHpp;
    }

    /**
     * @return
     */
    public int getmaxHp() {
        return maxHp;
    }

    Player() {

    }

    public abstract void firstAbility(Player enemy, char land);

    public abstract void secondAbility(Player enemy, char land);

    public abstract void damageOvertime(Player enemy, int k);

    public abstract void levelModifier(Player enemy);

    public abstract void totalDamage(Player enemy, char land);

    public abstract void acceptAngel(Angel angel);

    public abstract void chooseStrategy();
    public abstract void addobservers(Observator magician);
    public abstract void notifyall(String thestring);

    /**
     * @return
     */
    public boolean isroundDamageIndicator() {
        return roundDamageIndicator;
    }

    /**
     * @return
     */
    public int getdamageOvertime() {
        return damageOvertime;
    }

    /**
     * @param damageFirstAbilityy
     */
    public void setdamageFirstAbility(final int damageFirstAbilityy) {
        this.damageFirstAbility = damageFirstAbilityy;
    }

    /**
     * @param damageSecondAbilityy
     */
    public void setdamageSecondAbility(final int damageSecondAbilityy) {
        this.damageSecondAbility = damageSecondAbilityy;
    }

    /**
     * @param hpp
     */
    public void setHp(final int hpp) {
        this.hp = hpp;
    }

    /**
     * @param xpp
     */
    public void setXp(final int xpp) {
        this.xp = xpp;
    }

    /**
     * @param levell
     */
    public void setLevel(final int levell) {
        this.level = levell;
    }

    /**
     * @param hpp
     */
    public void modifyHp(final int hpp) {
        this.hp += hpp;
    }

    /**
     * @param roundDamageIndicatorr
     */
    public void setroundDamageIndicator(final boolean roundDamageIndicatorr) {
        this.roundDamageIndicator = roundDamageIndicatorr;
    }

    /**
     * @param numberRoundsDamagee
     */
    public void setnumberRoundsDamage(final int numberRoundsDamagee) {
        this.numberRoundsDamage = numberRoundsDamagee;
    }

    /**
     * @param damageOvertimee
     */
    public void setdamageOvertime(final int damageOvertimee) {
        this.damageOvertime = damageOvertimee;
    }

    /**
     * @return
     */
    public int getnumberRoundsDamage() {
        return numberRoundsDamage;
    }

    /**
     * @return
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * @return
     */
    public int getXp() {
        return xp;
    }

    /**
     * @return
     */
    public char getName() {
        return name;
    }

    /**
     * @param namee
     */
    public void setName(final char namee) {
        this.name = namee;
    }

    /**
     * @return
     */
    public int getdamageFirstAbility() {
        return damageFirstAbility;
    }

    /**
     * @return
     */
    public int getdamageSecondAbility() {
        return damageSecondAbility;
    }

    /**
     * @param xx
     */
    public void setX(final int xx) {
        this.x = xx;
    }

    /**
     * @param yy
     */
    public void setY(final int yy) {
        this.y = yy;
    }

    /**
     * @return
     */
    public int getHp() {
        return hp;
    }

    /**
     * @param damageFirstAbilityy
     */
    public void addDamageLevelFirst(final long damageFirstAbilityy) {
        this.damageFirstAbility += damageFirstAbilityy;
    }

    /**
     * @param damageSecondAbilityy
     */
    public void addDamageLevelSecond(final long damageSecondAbilityy) {
        this.damageSecondAbility += damageSecondAbilityy;
    }

    /**
     * @param xpp
     */
    public void modifiyXp(final int xpp) {
        this.xp += xpp;
    }
}
