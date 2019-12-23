package jp.ac.uryukyu.ie.e195741;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public LivingThing(String name, int maximumHP, int attack) {
        this.name = name;
        this.hitPoint = maximumHP;
        this.attack = attack;
        this.dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean isDead){
        this.dead = isDead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitpoint){
        this.hitPoint = hitpoint;
    }

    public int getAttack(){
        return attack;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }

    public void attack(LivingThing lives) {
        if(dead) return;
        int damage = (int) (Math.random() * attack);
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, lives.getName(), damage);
        lives.wounded(damage);
    }

    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint < 0) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}