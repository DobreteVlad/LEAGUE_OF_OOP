package players;
import util.Constants;

import static java.lang.Math.min;

public class Wizard extends Player {
    Wizard(final int x, final int y) {
        this.setX(x);
        this.setY(y);
        this.setHp(Constants.getInitialHpWizard());
        this.setLevel(0);
        this.setName('W');
        this.setdamageFirstAbility(0);
        this.setdamageSecondAbility(0);
        this.setroundDamageIndicator(false);
        this.setnumberRoundsDamage(Constants.getFOUR());
        this.setmaxHp(Constants.getInitialHpWizard());
        this.setincapacityMove(false);
    }

    /**
     *
     * @param enemy
     * @param land
     */
    public void firstAbility(final Player enemy, final char land) {
        // calculez procentele din viata ce trebuiesc scazute adversarului
        // dupa indicatii
        float aux = 1;
        if (land == 'D') {
            aux = Constants.getLandBonusDesert();
        }
        if (enemy.getName() == 'R') {
            this.setdamageFirstAbility(Math.round(Constants.getDrainRogue()
                    * ((Constants.getBaseDamageDrain() + Constants.getBoostDamageDrain()
                    * this.getLevel()) * aux)
                    * min(enemy.getmaxHp() * 0.3f, enemy.getHp())));
        }
        if (enemy.getName() == 'K') {
            this.setdamageFirstAbility(Math.round(Constants.getDrainKnight()
                    * ((Constants.getBaseDamageDrain() + Constants.getBoostDamageDrain()
                    * this.getLevel()) * aux)
                    * min(enemy.getmaxHp() * 0.3f, enemy.getHp())));
        }
        if (enemy.getName() == 'P') {
            this.setdamageFirstAbility(Math.round(Constants.getDrainPyromancer()
                    * ((Constants.getBaseDamageDrain() + Constants.getBoostDamageDrain()
                    * this.getLevel()) * aux)
                    * min(enemy.getmaxHp() * 0.3f, enemy.getHp())));
        }
        if (enemy.getName() == 'W') {
            this.setdamageFirstAbility(Math.round(Constants.getDrainWizard()
                    * ((Constants.getBaseDamageDrain() + Constants.getBoostDamageDrain()
                    * this.getLevel()) * aux)
                    * min(enemy.getmaxHp() * 0.3f, enemy.getHp())));
        }
    }

    /**
     *
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
                aux = Constants.getLandBonusDesert();
            }
            if (enemy.getName() == 'R') {
                if ((Constants.getBaseDamageDeflect() + 0.02 * this.getLevel()) < 0.7) {
                    this.setdamageSecondAbility(Math.round(Constants.getDeflectRogue()
                            * ((Constants.getBaseDamageDeflect()
                            + Constants.getBoostDamageDeflect() * this.getLevel())
                            * totalEnemyDamage * aux)));
                } else {
                    this.setdamageSecondAbility(Math.round(Constants.getDeflectRogue()
                            * (0.7f * totalEnemyDamage * aux)));
                }
            }
            if (enemy.getName() == 'K') {
                if ((Constants.getBaseDamageDeflect() + 0.02 * this.getLevel()) < 0.7) {
                    this.setdamageSecondAbility(Math.round(Constants.getDeflectKnight()
                            * ((Constants.getBaseDamageDeflect()+ Constants.getBoostDamageDeflect() * this.getLevel())
                            * totalEnemyDamage * aux)));
                } else {
                    this.setdamageSecondAbility(Math.round(Constants.getDeflectKnight()
                            * (0.7f * totalEnemyDamage * aux)));
                }
            }
            if (enemy.getName() == 'P') {
                if ((Constants.getBaseDamageDeflect() + 0.02 * this.getLevel()) < 0.7) {
                    this.setdamageSecondAbility(Math.round(Constants.getDeflectPyromancer()
                            * ((Constants.getBaseDamageDeflect()
                            + Constants.getBoostDamageDeflect() * this.getLevel())
                            * totalEnemyDamage * aux)));
                } else {
                    this.setdamageSecondAbility(Math.round(Constants.getDeflectPyromancer()
                            * (0.7f * totalEnemyDamage * aux)));
                }
            }
            // wizz-ul nu poate sa dea Deflect altui wizz
        }
    }

    /**
     *
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
     *
     * @param enemy
     */
    public void levelModifier(final Player enemy) {
        // daca adversarul este mort si nu din overtime
        // implementez cresterea in nivel
        // Totodata, resetez si viata dupa indicatii
        if (enemy.getHp() <= 0 && this.getdeadFromOvertime() == 0) {
            this.modifiyXp(Math.max(0, Constants.getFIFTY() * Constants.getFOUR()
                    - (this.getLevel() - enemy.getLevel()) * Constants.getFOURTY()));
            if (this.getXp() >= Constants.getFIFTY() * Constants.getFIVE()) {
                this.setLevel(this.getLevel() + 1
                        + ((this.getXp() - Constants.getFIFTY() * Constants.getFIVE())
                        / Constants.getFIFTY()));
                this.setHp(Constants.getInitialHpWizard() + Constants.getBoostHpWizard()
                        * this.getLevel());
                this.setmaxHp(this.getHp());
            }
        }
    }

    /**
     *
     * @param enemy
     * @param land
     */
    public void totalDamage(final Player enemy, final char land) {
        int totalDamage = this.getdamageFirstAbility()
                + this.getdamageSecondAbility();
        // calculezz dmg-ul total, il scad din viata adversarului si resetez
        // puterile inapoi la base dmg
        enemy.modifyHp(-totalDamage);
        this.setdamageFirstAbility(0);
        this.setdamageSecondAbility(0);
    }
}
