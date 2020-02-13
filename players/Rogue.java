package players;

import angels.Angel;
import main.Observator;
import strategy.Strategy;
import strategy.Atack;
import strategy.Defense;
import strategy.NormalAtack;
import util.Constants;
import util.RogueConstants;

public class Rogue extends Player {

    // pentru a putea salva modifierii pentru fiecare erou in parte
    // ii declar aici ca variabile
    // astfel devin unici pentru fiecare erou
    // iar ingerii pot modfica fara a mai avea grija ca se intersecteaza
    // modifierii de la eroi diferiti sau chiar de acelasi tip
    private float backstabROGUE;
    private float backstabKNIGHT;
    private float backstabPYROMANCER;
    private float backstabWIZARD;
    private float paralysisROGUE;
    private float paralysisKNIGHT;
    private float paralysisPYROMANCER;
    private float paralysisWIZARD;

    public final void setBACKSTABROGUE(final float backstabROGUEE) {
        this.backstabROGUE = backstabROGUEE;
    }

    public final void setBACKSTABKNIGHT(final float backstabKNIGHTT) {
        this.backstabKNIGHT = backstabKNIGHTT;
    }

    public final void setBACKSTABPYROMANCER(final float backstabPYROMANCERR) {
        this.backstabPYROMANCER = backstabPYROMANCERR;
    }

    public final void setBACKSTABWIZARD(final float backstabWIZARDD) {
        this.backstabWIZARD = backstabWIZARDD;
    }

    public final void setparalysisROGUE(final float paralysisROGUEE) {
        this.paralysisROGUE = paralysisROGUEE;
    }

    public final void setparalysisKNIGHT(final float paralysisKNIGHTT) {
        this.paralysisKNIGHT = paralysisKNIGHTT;
    }

    public final void setparalysisPYROMANCER(final float paralysisPYROMANCERR) {
        this.paralysisPYROMANCER = paralysisPYROMANCERR;
    }

    public final void setparalysisWIZARD(final float paralysisWIZARDD) {
        this.paralysisWIZARD = paralysisWIZARDD;
    }

    public final float getBACKSTABROGUE() {
        return backstabROGUE;
    }

    public final float getBACKSTABKNIGHT() {
        return backstabKNIGHT;
    }

    public final float getBACKSTABPYROMANCER() {
        return backstabPYROMANCER;
    }

    public final float getBACKSTABWIZARD() {
        return backstabWIZARD;
    }

    public final float getparalysisROGUE() {
        return paralysisROGUE;
    }

    public final float getparalysisKNIGHT() {
        return paralysisKNIGHT;
    }

    public final float getparalysisPYROMANCER() {
        return paralysisPYROMANCER;
    }

    public final float getparalysisWIZARD() {
        return paralysisWIZARD;
    }

    Rogue(final int x, final int y) {
        this.setX(x);
        this.setY(y);
        this.setHp(RogueConstants.getInitialHpRogue());
        this.setLevel(0);
        this.setName('R');
        this.setdamageFirstAbility(RogueConstants.getBaseDamageBackstab());
        this.setdamageSecondAbility(RogueConstants.getBaseDamageParalysis());
        this.setroundDamageIndicator(false);
        this.setnumberRoundsDamage(Constants.getFOUR());
        this.setdamageOvertime(Constants.getFIFTY());
        this.setmaxHp(RogueConstants.getInitialHpRogue());
        this.setincapacityMove(false);
        this.setdamageTotalNoRace(0);
        this.setBackstabNumberhits(Constants.getTWO());
        this.setnoEnter(false);
        this.setFullName("Rogue");
        this.setBACKSTABROGUE(RogueConstants.getModifierBackstabRogue());
        this.setBACKSTABKNIGHT(RogueConstants.getModifierBackstabKnight());
        this.setBACKSTABPYROMANCER(RogueConstants.getModifierBackstabPyromancer());
        this.setBACKSTABWIZARD(RogueConstants.getModifierBackstabWizard());
        this.setparalysisROGUE(RogueConstants.getModifierParalysisRogue());
        this.setparalysisKNIGHT(RogueConstants.getModifierParalysisKnight());
        this.setparalysisPYROMANCER(RogueConstants.getModifierParalysisPyromancer());
        this.setparalysisWIZARD(RogueConstants.getModifierParalysisWizard());
    }
    // Se accepta vist-ul de la fiecare inger
    public final void acceptAngel(final Angel angel) {
        angel.visit(this);
    }

    // In functie de cerinta, playerul alege una din cele 3 strategii
    public final void chooseStrategy() {
        if (this.getHp() > this.getmaxHp() / Constants.getSEVEN() && this.getHp()
                < this.getmaxHp() / Constants.getFIVE()) {
            Strategy mystrategy = new Atack();
            mystrategy.applyStrategy(this);
        } else if (this.getHp() < this.getmaxHp() / Constants.getSEVEN()) {
            Strategy mystrategy = new Defense();
            mystrategy.applyStrategy(this);
        } else {
            Strategy mystrategy = new NormalAtack();
            mystrategy.applyStrategy(this);
        }

    }

    @Override
    public final void addobservers(final Observator magician) {
        this.observer.add(magician);
    }

    // daca apare o notificare, magicianul este anuntat
    @Override
    public final void notifyall(final String thestring) {
        for (int i = 0; i < observer.size(); i++) {
            observer.get(i).update(thestring);
        }
    }

    /**
     * @param enemy
     * @param land
     */
    public void firstAbility(final Player enemy, final char land) {
        // aplic Critical Backstab daca este pe teren de tip Woods
        // contorizez numarul de lovituri pentru a lovi din nou cu Critical
        this.setBackstabNumberhits(this.getBackstabNumberhits() + 1);
        this.addDamageLevelFirst(RogueConstants.getBoostDamageBackstab()
                * this.getLevel());
        float x = this.getdamageFirstAbility();
        if (this.getBackstabNumberhits() == Constants.getTHREE()
                && land == 'W') {
            x = (float) (x * Constants.getONEHALF());
            this.setBackstabNumberhits(0);
        }
        if (land == 'W') {
            x = (Math.round(x * RogueConstants.getLandBonusWoods()));
        }
        if (this.getBackstabNumberhits() == Constants.getTHREE() && land == 'W') {
            x = (float) (x * Constants.getONEHALF());
        } else if (this.getBackstabNumberhits() == Constants.getTHREE()) {
            this.setBackstabNumberhits(0);
        }
        this.modifyDamageTotalNoRace(Math.round(x));
        if (enemy.getName() == 'R') {
            x = (x * this.getBACKSTABROGUE());
        }
        if (enemy.getName() == 'K') {
            x = (x * this.getBACKSTABKNIGHT());
        }
        if (enemy.getName() == 'P') {
            x = (x * this.getBACKSTABPYROMANCER());
        }
        if (enemy.getName() == 'W') {
            x = (x * this.getBACKSTABWIZARD());
        }
        this.setdamageFirstAbility(Math.round(x));
    }

    /**
     * @param enemy
     * @param land
     */
    @Override
    public void secondAbility(final Player enemy, final char land) {
        // setez conditiile de dmgOvertime pt adversar
        this.addDamageLevelSecond(RogueConstants.getBoostDamageParalysis()
                * this.getLevel());
        enemy.setroundDamageIndicator(true);
        enemy.setincapacityMove(true);
        float x = this.getdamageSecondAbility();
        // daca este pe teren de tip Woods, aplicam bonusurile
        if (land == 'W') {
            if (!this.isnoEnter()) {
                enemy.setnumberRoundsDamage(Constants.getSIX());
            }
            enemy.setbigOvertime(true);
            enemy.setincapacityMove(true);
            this.setnoEnter(true);
        }
        if (land == 'W') {
            x = (Math.round(x * RogueConstants.getLandBonusWoods()));
        }
        this.modifyDamageTotalNoRace(Math.round(x));
        if (enemy.getName() == 'R') {
            x = (x * this.getparalysisROGUE());
        }
        if (enemy.getName() == 'K') {
            x = (x * this.getparalysisKNIGHT());
        }
        if (enemy.getName() == 'P') {
            x = (x * this.getparalysisPYROMANCER());
        }
        if (enemy.getName() == 'W') {
            x = (x * this.getparalysisWIZARD());
        }
        // setez dmgOvertime pentru adversar
        enemy.setdamageOvertime(Math.round(x));
        this.setdamageSecondAbility(Math.round(x));
    }

    /**
     * @param enemy
     * @param k
     */
    public void damageOvertime(final Player enemy, final int k) {
        // scad damage-ul primit in overtime in functie de adversar
        // numarul de runde depinde de adversar si teren
        if (this.isroundDamageIndicator()) {
            if (this.isbigOvertime()) {
                if (this.getnumberRoundsDamage() >= Constants.getFOUR()
                        && this.getnumberRoundsDamage() <= Constants.getSIX()
                        && enemy.getName() == 'R') {
                    this.modifyHp(-this.getdamageOvertime());
                    this.setincapacityMove(true);
                }
            }
            if (this.getnumberRoundsDamage() >= 1
                    && this.getnumberRoundsDamage() <= Constants.getTHREE()
                    && enemy.getName() == 'R') {
                this.modifyHp(-this.getdamageOvertime());
                this.setincapacityMove(true);
            } else if (this.getnumberRoundsDamage() >= Constants.getTWO()
                    && this.getnumberRoundsDamage() <= Constants.getTHREE()
                    && enemy.getName() == 'P') {
                this.modifyHp(-this.getdamageOvertime());
            }
        }
        this.setnumberRoundsDamage(this.getnumberRoundsDamage() - 1);
        if (this.getnumberRoundsDamage() == 0) {
            this.setroundDamageIndicator(false);
        }
        if (this.getHp() <= 0) {
            this.setdeadFromOvertime(1);
        }
    }

    /**
     * @param enemy
     */
    public void levelModifier(final Player enemy) {
        // daca adversarul este mort si nu din overtime
        // implementez cresterea in nivel
        // Totodata, resetez si viata dupa indicatii
        int level = this.getLevel();

        if (enemy.getHp() <= 0 && this.getdeadFromOvertime() == 0 && this.getHp() > 0) {
            int auxx = this.getLevel();
            while (this.getXp() + Math.max(0, Constants.getFIFTY() * Constants.getFOUR()
                    - (auxx - enemy.getLevel()) * Constants.getFOURTY())
                    >= Constants.getFIFTY() * Constants.getFIVE() + this.getLevel()
                    * Constants.getFIFTY()) {
                this.setLevel(this.getLevel() + 1);
                this.setHp(this.getmaxHp() + Constants.getFOURTY());
                this.setmaxHp(this.getHp());
            }
            this.modifiyXp(Math.max(0, Constants.getFIFTY()
                    * Constants.getFOUR() - (auxx
                    - enemy.getLevel()) * Constants.getFOURTY()));

            if (level < this.getLevel()) {
                int aux = this.getLevel() - level;
                for (int i = 0; i < aux; i++) {
                    level++;
                    String string = this.getFullName() + " " + this.getNumberOfPlayer()
                            + " reached level " + level;
                    this.notifyall(string);
                }
            }
        }
    }

    /**
     * @param enemy
     * @param land
     */
    public void totalDamage(final Player enemy, final char land) {

        if (enemy.getHp() > 0) {
            int totalDamage = this.getdamageFirstAbility()
                    + this.getdamageSecondAbility();
            if (enemy.getHp() > 0 && enemy.getHp() - totalDamage <= 0) {
                String string = "Player " + enemy.getFullName() + " "
                        + enemy.getNumberOfPlayer() + " was killed by " + this.getFullName()
                        + " " + this.getNumberOfPlayer();
                this.notifyall(string);
            }
            enemy.modifyHp(-totalDamage);
            // calculezz dmg-ul total, il scad din viata adversarului si resetez
            // puterile inapoi la base dmg
            this.setdamageFirstAbility(RogueConstants.getBaseDamageBackstab());
            this.setdamageSecondAbility(RogueConstants.getBaseDamageParalysis());
        }
    }
}
