package jp.ac.uryukyu.ie.e195741;
/**
 * 名前やHPなどの要素を持った生き物のクラス。
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;
    /**
     * LivingThingクラスのコンストラクタ
     * @param name 名前
     * @param maximumHP 最大ヒットポイント
     * @param attack 攻撃力
     */
    public LivingThing(String name, int maximumHP, int attack) {
        this.name = name;
        this.hitPoint = maximumHP;
        this.attack = attack;
        this.dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }
    /**
     * 死亡判定をするメソッド
     * @return 生きている時はfalseを返す
     */
    public boolean isDead() {
        return dead;
    }
    /**
     * 死亡しているかを設定するメソッド
     * @param isDead 死亡時はtrue、生きている時はfalse
     */
    public void setDead(boolean isDead){
        this.dead = isDead;
    }
    /**
     * 名前を返すメソッド
     * @return 名前
     */
    public String getName() {
        return name;
    }
    /**
     * 名前を設定するメソッド
     * @param name 名前
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * HPを返すメソッド
     * @return HP
     */
    public int getHitPoint() {
        return hitPoint;
    }
    /**
     * HPを設定するメソッド
     * @param hitpoint HP
     */
    public void setHitPoint(int hitpoint){
        this.hitPoint = hitpoint;
    }
    /**
     * 攻撃力を返すメソッド
     * @return 攻撃力
     */
    public int getAttack(){
        return attack;
    }
    /**
     * 攻撃力を設定するメソッド
     * @param attack 攻撃力
     */
    public void setAttack(int attack){
        this.attack = attack;
    }

    /**
     * 対象に攻撃をするメソッド
     * attackと乱数からダメージ量を決め、lives.wounded(damage)でダメージ処理をさせる
     * @param lives 攻撃の対象
     */
    public void attack(LivingThing lives) {
        if(dead) return;
        int damage = (int) (Math.random() * attack);
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, lives.getName(), damage);
        lives.wounded(damage);
    }

    /**
     * 攻撃された時にダメージ処理を行うメソッド
     * 受け取ったdamageをhitpointから引き死亡の判定を行う
     * @param damage 受けたダメージ量
     */
    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint < 0) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}