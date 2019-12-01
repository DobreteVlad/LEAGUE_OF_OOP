package players;

import util.Constants;

public class Rogue extends Player {
    Rogue(final int x, final int y) {
        this.setX(x);
        this.setY(y);
        this.setHp(Constants.getInitialHpRogue());
        this.setLevel(0);
        this.setName('R');
        this.setdamageFirstAbility(Constants.getBaseDamageBackstab());
        this.setdamageSecondAbility(Constants.getBaseDamageParalysis());
        this.setroundDamageIndicator(false);
        this.setnumberRoundsDamage(Constants.getFOUR());
        this.setdamageOvertime(Constants.getFIFTY());
        this.setmaxHp(Constants.getInitialHpRogue());
        this.setincapacityMove(false);
        this.setdamageTotalNoRace(0);
        this.setBackstab_numberhits(Constants.getTWO());
        this.setnoEnter(false);
    }

    /**
     *
     * @param enemy
     * @param land
     */
    public void firstAbility(final Player enemy, final char land) {
        this.setBackstab_numberhits(this.getBackstab_numberhits() + 1);
        this.addDamageLevelFirst(Constants.getBoostDamageBackstab()
                * this.getLevel());
        float x = this.getdamageFirstAbility();
        if (this.getBackstab_numberhits() == Constants.getTHREE()
                && land == 'W') {
            x = (float) (x * 1.5);
            this.setBackstab_numberhits(0);
        }
        if (land == 'W') {
            x = (x * Constants.getLandBonusWoods());
        }
        if (this.getBackstab_numberhits() == Constants.getTHREE() && land == 'W') {
            x = (float) (x * 1.5);
        } else if (this.getBackstab_numberhits() == Constants.getTHREE()) {
            this.setBackstab_numberhits(0);
        }
        this.modifyDamageTotalNoRace(Math.round(x));
        if (enemy.getName() == 'R') {
            x = (x * Constants.getBackstabRogue());
        }
        if (enemy.getName() == 'K') {
            x = (x * Constants.getBackstabKnight());
        }
        if (enemy.getName() == 'P') {
            x = (x * Constants.getBackstabPyromancer());
        }
        if (enemy.getName() == 'W') {
            x = (x * Constants.getBackstabWizard());
        }
        this.setdamageFirstAbility(Math.round(x));
    }

    /**
     *
     * @param enemy
     * @param land
     */
    @Override
    public void secondAbility(final Player enemy, final char land) {
        this.addDamageLevelSecond(Constants.getBoostDamageParalysis()
                * this.getLevel());
        enemy.setroundDamageIndicator(true);
        enemy.setincapacityMove(true);
        float x = this.getdamageSecondAbility();
        if (land == 'W') {
            if (!this.isnoEnter()) {
                enemy.setnumberRoundsDamage(Constants.getSIX());
            }
            enemy.setbigOvertime(true);
            enemy.setincapacityMove(true);
            this.setnoEnter(true);
        }
        if (land == 'W') {
            x = (x * Constants.getLandBonusWoods());
        }
        this.modifyDamageTotalNoRace(Math.round(x));
        if (enemy.getName() == 'R') {
            x = (x * Constants.getParalysisRogue());
        }
        if (enemy.getName() == 'K') {
            x = (x * Constants.getParalysisKnight());
        }
        if (enemy.getName() == 'P') {
            x = (x * Constants.getParalysisPyromancer());
        }
        if (enemy.getName() == 'W') {
            x = (x * Constants.getParalysisWizard());
        }
        enemy.setdamageOvertime(Math.round(x));
        this.setdamageSecondAbility(Math.round(x));
    }

    /**
     *
     * @param enemy
     * @param k
     */
    public void damageOvertime(final Player enemy, final int k) {
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
        if (enemy.getHp() <= 0 && this.getdeadFromOvertime() == 0) {
            this.modifiyXp(Math.max(0, Constants.getFIFTY()
                    * Constants.getFOUR() - (this.getLevel()
                    - enemy.getLevel()) * Constants.getFOURTY()));
            if (this.getXp() >= Constants.getFIFTY() * Constants.getFIVE()) {
                this.setLevel(this.getLevel() + 1
                        + ((this.getXp() - Constants.getFIFTY()
                        * Constants.getFIVE()) / Constants.getFIFTY()));
                this.setHp(Constants.getInitialHpRogue()
                        + Constants.getFOURTY() * this.getLevel());
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
        if (enemy.getHp() > 0) {
        int totalDamage = this.getdamageFirstAbility()
                + this.getdamageSecondAbility();
        enemy.modifyHp(-totalDamage);
        this.setdamageFirstAbility(Constants.getBaseDamageBackstab());
        this.setdamageSecondAbility(Constants.getBaseDamageParalysis());
        }
    }
}
