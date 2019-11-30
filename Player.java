package players;
import static java.lang.StrictMath.max;

abstract public class Player {
       private int hp;
       private int xp;
       private int level;
       private int damage_first_ability;
       private int damage_second_ability;
       private char name;
       private int x;
       private int y;
       private boolean round_damage_indicator;
       private int number_rounds_damage;
       private int damage_overtime;
       private int max_hp;
       private boolean incapacity_move;
       private float Damage_total_norace;
       private int Backstab_numberhits;

    public void setBackstab_numberhits(int backstab_numberhits) {
        Backstab_numberhits = backstab_numberhits;
    }

    public int getBackstab_numberhits() {
        return Backstab_numberhits;
    }

    public void setDamage_total_norace(float damage_total_norace) {
        Damage_total_norace = damage_total_norace;
    }

    public float getDamage_total_norace() {
        return Damage_total_norace;
    }
    public void Modify_damage_total_norace(float damage_total_norace){
        this.Damage_total_norace+=damage_total_norace;
    }

    public void setIncapacity_move(boolean incapacity_move) {
        this.incapacity_move = incapacity_move;
    }

    public boolean isIncapacity_move() {
        return incapacity_move;
    }

    public void setMax_hp(int max_hp) {
        this.max_hp = max_hp;
    }

    public int getMax_hp() {
        return max_hp;
    }

    Player(){

    }
    public abstract void First_Ability(Player enemy, char land);
    public abstract void  Second_ability(Player enemy, char land);
    public abstract void Damage_overtime(Player enemy);
    public abstract void Level_modifier(Player enemy);
    public abstract void Total_Damage(Player enemy,char land);


    public boolean isRound_damage_indicator() {
        return round_damage_indicator;
    }

    public int getDamage_overtime() {
        return damage_overtime;
    }

    public void setDamage_first_ability(int damage_first_ability) {
        this.damage_first_ability = damage_first_ability;
    }

    public void setDamage_second_ability(int damage_second_ability) {
        this.damage_second_ability = damage_second_ability;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void Modify_hp(int hp){
        this.hp += hp;
    }
    public void Modify_xp(int level_winner, int level_loser){
        xp = xp + max(0, 200 - (level_winner - level_loser) * 40);
    }
    public void XP_level_up(){
        int XP_level_up= 250 + level*50;
        if(XP_level_up - level >= 50){
            level++;
        }
    }

    public void setRound_damage_indicator(boolean round_damage_indicator) {
        this.round_damage_indicator = round_damage_indicator;
    }

    public void setNumber_rounds_damage(int number_rounds_damage) {
        this.number_rounds_damage = number_rounds_damage;
    }

    public void setDamage_overtime(int damage_overtime) {
        this.damage_overtime = damage_overtime;
    }

    public int getNumber_rounds_damage() {
        return number_rounds_damage;
    }

    public int getLevel() {
        return level;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getXp() {
        return xp;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public int getDamage_first_ability() {
        return damage_first_ability;
    }

    public int getDamage_second_ability() {
        return damage_second_ability;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHp() {
        return hp;
    }
    public void AddDamage_Level_First(long damage_first_ability){
        this.damage_first_ability += damage_first_ability;
    }
    public void AddDamage_Level_Second(long damage_second_ability){
        this.damage_second_ability += damage_second_ability;
    }

    public void ModifyDamage_first_ability(float coeficient){
        this.damage_first_ability = Math.round(this.damage_first_ability * coeficient);
    }
    public void ModifyDamage_second_ability(float coeficient){
        this.damage_second_ability =Math.round(this.damage_second_ability*coeficient) ;
    }
    public void Modifiy_Xp(int xp){
        this.xp += xp;
    }
}
