package characters;

public class WildMinion extends Enemy{

    //CONSTRUCTOR
    public WildMinion(int level, double hp, double ether, double attack, double defense, boolean statusParalysis){
        super(level, hp, ether, attack, defense, statusParalysis);
    }
    public void regularAttack(Hero hero){
		if (hero.getDefense() < (1.2 * getAttack())){
		System.out.println("Wild minion dealed " + (1.2 * getAttack() - (hero.getDefense())) + " damage.");
			hero.setHp((hero.getHp() + hero.getDefense()) - (1.2 * getAttack()));   
        }
        else{
            System.out.println("Wild minion is too weak, he dealed no damage!");
        }
	}
}