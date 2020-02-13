package players;

import angels.Angel;
import main.Observator;
import strategy.Atack;
import strategy.Defense;
import strategy.NormalAtack;
import strategy.Strategy;
import util.Constants;
import util.WizardConstants;

import static java.lang.Math.min;

public class Wizard extends Player {

    // pentru a putea salva modifierii pentru fiecare erou in parte
    // ii declar aici ca variabile
    // astfel devin unici pentru fiecare erou
    // iar ingerii pot modfica fara a mai avea grija ca se intersecteaza
    // modifierii de la eroi diferiti sau chiar de acelasi tip
    private float drainROGUE;
    private float drainKNIGHT;
    private float drainPYROMANCER;
    private float drainWIZARD;
    private float deflectROGUE;
    private float deflectKNIGHT;
    private float deflectPYROMANCER;

    public final void setDrainROGUE(final float drainROGUE) {
        this.drainROGUE = drainROGUE;
    }

    public final void setDrainKNIGHT(final float drainKNIGHT) {
        this.drainKNIGHT = drainKNIGHT;
    }

    public final void setDrainPYROMANCER(final float drainPYROMANCER) {
        this.drainPYROMANCER = drainPYROMANCER;
    }

    public final void setDrainWIZARD(final float drainWIZARD) {
        this.drainWIZARD = drainWIZARD;
    }

    public final void setDeflectROGUE(final float deflectROGUE) {
        this.deflectROGUE = deflectROGUE;
    }

    public final void setDeflectKNIGHT(final float deflectKNIGHT) {
        this.deflectKNIGHT = deflectKNIGHT;
    }

    public final void setDeflectPYROMANCER(final float deflectPYROMANCER) {
        this.deflectPYROMANCER = deflectPYROMANCER;
    }

    public final float getDrainROGUE() {
        return drainROGUE;
    }

    public final float getDrainKNIGHT() {
        return drainKNIGHT;
    }

    public final float getDrainPYROMANCER() {
        return drainPYROMANCER;
    }

    public final float getDrainWIZARD() {
        return drainWIZARD;
    }

    public final float getDeflectROGUE() {
        return deflectROGUE;
    }

    public final float getDeflectKNIGHT() {
        return deflectKNIGHT;
    }

    public final float getDeflectPYROMANCER() {
        return deflectPYROMANCER;
    }

    Wizard(final int x, final int y) {
        this.setX(x);
        this.setY(y);
        this.setHp(WizardConstants.getInitialHpWizard());
        this.setLevel(0);
        this.setName('W');
        this.setdamageFirstAbility(0);
        this.setdamageSecondAbility(0);
        this.setroundDamageIndicator(false);
        this.setnumberRoundsDamage(Constants.getFOUR());
        this.setmaxHp(WizardConstants.getInitialHpWizard());
        this.setincapacityMove(false);
        this.setFullName("Wizard");
        this.setDrainROGUE(WizardConstants.getModifierDrainRogue());
        this.setDrainKNIGHT(WizardConstants.getModifierDrainKnight());
        this.setDrainPYROMANCER(WizardConstants.getModifierDrainPyromancer());
        this.setDrainWIZARD(WizardConstants.getModifierDrainWizard());
        this.setDeflectROGUE(WizardConstants.getModifierDeflectRogue());
        this.setDeflectKNIGHT(WizardConstants.getModifierDeflectKnight());
        this.setDeflectPYROMANCER(WizardConstants.getModifierDeflectPyromancer());
    }
    // Se accepta vist-ul de la fiecare inger
    public final void acceptAngel(final Angel angel) {
        angel.visit(this);
    }

    // In functie de cerinta, playerul alege una din cele 3 strategii
    public final void chooseStrategy() {
        if (this.getHp() > this.getmaxHp() / Constants.getFOUR() && this.getHp() < this.getmaxHp()
                / Constants.getTWO()) {
            Strategy mystrategy = new Atack();
            mystrategy.applyStrategy(this);
        } else if (this.getHp() < this.getmaxHp() / Constants.getFOUR()) {
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
        // calculez procentele din viata ce trebuiesc scazute adversarului
        // dupa indicatii
        float aux = 1;
        if (land == 'D') {
            aux = WizardConstants.getLandBonusDesert();
        }
        if (enemy.getName() == 'R') {
            this.setdamageFirstAbility(Math.round(this.getDrainROGUE()
                    * ((WizardConstants.getBaseDamageDrain()
                    + WizardConstants.getBoostDamageDrain()
                    * this.getLevel()) * aux)
                    * min(enemy.getmaxHp() * Constants.getTHREEE(), enemy.getHp())));
        }
        if (enemy.getName() == 'K') {
            this.setdamageFirstAbility(Math.round(this.getDrainKNIGHT()
                    * ((WizardConstants.getBaseDamageDrain()
                    + WizardConstants.getBoostDamageDrain()
                    * this.getLevel()) * aux)
                    * min(enemy.getmaxHp() * Constants.getTHREEE(), enemy.getHp())));
        }
        if (enemy.getName() == 'P') {
            this.setdamageFirstAbility(Math.round(this.getDrainPYROMANCER()
                    * ((WizardConstants.getBaseDamageDrain()
                    + WizardConstants.getBoostDamageDrain()
                    * this.getLevel()) * aux)
                    * min(enemy.getmaxHp() * Constants.getTHREEE(), enemy.getHp())));
        }
        if (enemy.getName() == 'W') {
            this.setdamageFirstAbility(Math.round(this.drainWIZARD
                    * ((WizardConstants.getBaseDamageDrain()
                    + WizardConstants.getBoostDamageDrain()
                    * this.getLevel()) * aux)
                    * min(enemy.getmaxHp() * Constants.getTHREEE(), enemy.getHp())));
        }
    }

    /**
     * @param enemy
     * @param land
     */
    @Override
    public void secondAbility(final Player enemy, final char land) {
        if (enemy.getName() != 'W') {
            float aux = 1;
            //specific wizzului, acesta scada un procent din dmg total al adversarului
            float totalEnemyDamage = enemy.getdamageTotalNoRace();
            enemy.modifyDamageTotalNoRace(-enemy.getdamageTotalNoRace());
            if (land == 'D') {
                aux = WizardConstants.getLandBonusDesert();
            }
            if (enemy.getName() == 'R') {
                if ((WizardConstants.getBaseDamageDeflect() + Constants.getTWOO()
                        * this.getLevel()) < Constants.getSEVENN()) {
                    this.setdamageSecondAbility(Math.round(this.getDeflectROGUE()
                            * ((WizardConstants.getBaseDamageDeflect()
                            + WizardConstants.getBoostDamageDeflect() * this.getLevel())
                            * totalEnemyDamage * aux)));
                } else {
                    this.setdamageSecondAbility(Math.round(this.getDeflectROGUE()
                            * (Constants.getSEVENN() * totalEnemyDamage * aux)));
                }
            }
            if (enemy.getName() == 'K') {
                if ((WizardConstants.getBaseDamageDeflect() + Constants.getTWOO()
                        * this.getLevel()) < Constants.getSEVENN()) {
                    this.setdamageSecondAbility(Math.round(this.getDeflectKNIGHT()
                            * ((WizardConstants.getBaseDamageDeflect()
                            + WizardConstants.getBoostDamageDeflect() * this.getLevel())
                            * totalEnemyDamage * aux)));
                } else {
                    this.setdamageSecondAbility(Math.round(this.getDeflectKNIGHT()
                            * (Constants.getSEVENN() * totalEnemyDamage * aux)));
                }
            }
            if (enemy.getName() == 'P') {
                if ((WizardConstants.getBaseDamageDeflect() + Constants.getTWOO()
                        * this.getLevel()) < Constants.getSEVENN()) {
                    this.setdamageSecondAbility(Math.round(this.getDeflectPYROMANCER()
                            * ((WizardConstants.getBaseDamageDeflect()
                            + WizardConstants.getBoostDamageDeflect() * this.getLevel())
                            * totalEnemyDamage * aux)));
                } else {
                    this.setdamageSecondAbility(Math.round(this.getDeflectPYROMANCER()
                            * (Constants.getSEVENN() * totalEnemyDamage * aux)));
                }
            }
            // wizz-ul nu poate sa dea Deflect altui wizz
        }
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
                    - (auxx - enemy.getLevel()) * Constants.getFOURTY()) >= Constants.getFIFTY()
                    * Constants.getFIVE() + this.getLevel()
                    * Constants.getFIFTY()) {
                this.setLevel(this.getLevel() + 1);
                this.setHp(this.getmaxHp() + Constants.getTHREE() * Constants.getTEN());
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
        int totalDamage = this.getdamageFirstAbility()
                + this.getdamageSecondAbility();
        if (enemy.getHp() > 0 && enemy.getHp() - totalDamage <= 0) {
            String string = "Player " + enemy.getFullName() + " " + enemy.getNumberOfPlayer()
                    + " was killed by " + this.getFullName() + " " + this.getNumberOfPlayer();
            this.notifyall(string);
        }
        // calculezz dmg-ul total, il scad din viata adversarului si resetez
        // puterile inapoi la base dmg
        enemy.modifyHp(-totalDamage);
        this.setdamageFirstAbility(0);
        this.setdamageSecondAbility(0);
    }
}
