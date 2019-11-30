package players;
import java.lang.Math;


public class Pyromancer extends Player {
    Pyromancer(int x, int y){
        this.setX(x);
        this.setY(y);
        this.setHp(500);
        this.setLevel(0);
        this.setXp(0);
        this.setName('P');
        this.setDamage_first_ability(350);
        this.setDamage_second_ability(150);
        this.setRound_damage_indicator(false);
        this.setNumber_rounds_damage(4);
        this.setDamage_overtime(50);
        this.setMax_hp(500);
        this.setIncapacity_move(false);
        this.setDamage_total_norace(0);
    }
    public void First_Ability(Player enemy, char land) {
        this.AddDamage_Level_First(50*this.getLevel());
        float x=this.getDamage_first_ability();
        if(land=='V'){
            x= (float) (x*1.25);
        }
        this.Modify_damage_total_norace(Math.round(x));
        //System.out.println(this.getDamage_total_norace());
        if(enemy.getName() == 'R'){
            x= (float) (x*0.8);
        }
        if(enemy.getName() == 'K'){
            x= (float) (x*1.2);
        }
        if(enemy.getName() == 'P'){
            x= (float) (x*0.9);
        }
        if(enemy.getName() == 'W'){
            x= (float) (x*1.05);
        }
        this.setDamage_first_ability(Math.round(x));
        //System.out.println(getDamage_first_ability());
    }

    public void Second_ability(Player enemy,  char land) {
        enemy.setRound_damage_indicator(true);
        float k = 50 * this.getLevel();
        this.AddDamage_Level_Second(20*this.getLevel());
        float x=this.getDamage_second_ability();
        if(land=='V'){
            x= (float) (x*1.25);
            k = (float) (k*1.25);
            //System.out.println(getDamage_first_ability());
        }
        this.Modify_damage_total_norace(Math.round(x));
        if(enemy.getName() == 'R'){
            x= (float) (x*0.8);
            k = (float) (k*0.8);
        }
        if(enemy.getName() == 'K'){
            x= (float) (x*1.2);
            k = (float) (k*1.2);
        }
        if(enemy.getName() == 'P'){
            x= (float) (x*0.9);
            k = (float) (k*0.9);
        }
        if(enemy.getName() == 'W'){
            x= (float) (x*1.05);
            k = (float) (k*1.05);
        }
        this.setDamage_second_ability(Math.round(x));
        //enemy.setDamage_total_norace(k);
        //System.out.println(getDamage_second_ability()+" ");
    }
    public void Damage_overtime(Player enemy){
        if(this.isRound_damage_indicator()){
            // System.out.println(this.getNumber_rounds_damage());
            if(this.getNumber_rounds_damage()>=1 && this.getNumber_rounds_damage()<=3 && enemy.getName()=='R'){
                //System.out.println("da");
                this.Modify_hp(-this.getDamage_overtime());
            }
            else if(this.getNumber_rounds_damage()>=2 && this.getNumber_rounds_damage()<=3 && enemy.getName()=='P'){
                this.Modify_hp(-this.getDamage_overtime());
            }
            this.setNumber_rounds_damage(this.getNumber_rounds_damage() - 1);
            //System.out.println(this.getNumber_rounds_damage());
        }


    }
   public void Level_modifier(Player enemy){
        if(enemy.getHp() <= 0 ){
            this.Modifiy_Xp(Math.max(0, 200 -(this.getLevel()-enemy.getLevel())*40));
            if(250 + this.getLevel()*50  <= this.getXp()){
                this.setLevel(this.getLevel() + 1);
                this.setHp(500 + 50*this.getLevel());
                this.setMax_hp(this.getHp());
            }
        }
    }
    public void Total_Damage(Player enemy, char land){
        //System.out.println(this.getDamage_first_ability()+ " " + this.getDamage_second_ability());
        int total_damage = this.getDamage_first_ability() + this.getDamage_second_ability();
       // System.out.println(total_damage);
        enemy.Modify_hp(-total_damage);
        this.setDamage_first_ability(350);
        this.setDamage_second_ability(150);
    }
}
