package oops;
interface upgradeable{
    void upgradeWeapon();
    void upgradeArmor();
}

abstract class Robot {
    private String robotName;
    private int energyLevel;
    private int health;
    private int weaponPower;

    Robot(String robotName, int energyLevel, int health, int weaponPower) {
        if (robotName != null && energyLevel >= 0 && health >= 0 && weaponPower >= 0) {
            this.robotName = robotName;
            this.energyLevel = energyLevel;
            this.health = health;
            this.weaponPower = weaponPower;
            System.out.println(robotName + " Initialized Successfully");
        } else {
            System.out.println("INVALID ROBOT DATA:");

        }
    }
        public String getrobotName(){
            return robotName;
        }
        public int getEnergyLevel(){
        return energyLevel;
    }
    public int getHealth(){
        return health;
    }
    public int getWeaponPower(){
        return weaponPower;
    }
    public void setEnergyLevel(int energyLevel){
        this.energyLevel=energyLevel;
    }
    public void setHealth(int health){
        this.health=health;
    }
    public void setWeaponPower(int weaponPower){
        this.weaponPower=weaponPower;
    }

    abstract void attack();//abstract method 1

    abstract void specialAbility();//abstract method 2

    void showStats() {
        System.out.println("Robot Name : " +robotName);
        System.out.println("Energy Level : " +energyLevel);
        System.out.println("Health : " + health);
        System.out.println("Weapon Power : " + weaponPower);
    }
}class BattleBot extends Robot implements upgradeable{
    private boolean rageMode;
    BattleBot(String robotName,int energyLevel,int health,int weaponPower){
        super(robotName, energyLevel, health, weaponPower);
    }

    @Override
    void attack() {
        if(getEnergyLevel()<=0){
            System.out.println("SYSTEM FAILURE : ");
            return;
        }
        if(getHealth()<30){
            rageMode=true;
            setWeaponPower(getWeaponPower()+20);
            System.out.println("RAGE MODE ACTIVATED : ");
            System.out.println(getrobotName()+"uses Missile Attacks");
            setEnergyLevel(getEnergyLevel()-20);
        }
    }
    void specialAbility(){
        System.out.println(getrobotName()+"activated Rage Mode ");
    }
    @Override
    public void upgradeWeapon(){
        setWeaponPower(getWeaponPower()+15);
        System.out.println("Weapon Upgraded:");
    }
    @Override
    public void upgradeArmor(){
        setHealth(getHealth()+20);
        System.out.println("Armor Upgraded:");
    }
}
class ThunderBot extends Robot implements upgradeable {
    ThunderBot(String robotName, int energyLevel, int health, int weaponPower) {
        super(robotName, energyLevel, health, weaponPower);
    }

        @Override
        void attack () {
            if(getEnergyLevel()<=0){
                System.out.println("SYSTEM FAILURE : ");
                return;
            }
            System.out.println(getrobotName()+" uses Electric Shock");
            setEnergyLevel(getEnergyLevel()-15);
        }
        @Override
        void specialAbility () {
            System.out.println(getrobotName()+"EMP Blast Activated");
        }
        @Override
    public void upgradeWeapon() {
            setWeaponPower(getWeaponPower() + 10);
            System.out.println(" Electric Weapon Upgraded:");
        }
            @Override
            public void upgradeArmor(){
                setHealth(getHealth()+15);System.out.println("Titan Armor Upgraded:");
    }
}
class ShadowBot extends Robot{
    ShadowBot(String robotName, int energyLevel, int health,int weaponPower){
        super(robotName, energyLevel, health, weaponPower);
    }
    @Override
    void attack () {
        if(getEnergyLevel()<=0){
            System.out.println("SYSTEM FAILURE : ");
            return;
        }
        System.out.println(getrobotName()+" uses Stealth Attack");
        setEnergyLevel(getEnergyLevel()-10);
    }
    @Override
    void specialAbility () {
        System.out.println(getrobotName()+" Activated Invisible Mode ");
    }
}
public class RobotBattleSystem {
    static void main(String[] args) {
        Robot r1 = new BattleBot("DestroyerX", 100, 25, 50);
        Robot r2 = new ThunderBot("ThunderZero", 120, 80, 40);
        Robot r3 = new ShadowBot("GhostReaper", 90, 60, 35);
        r1.attack();
        r1.specialAbility();
        r1.showStats();

        System.out.println();

        r2.attack();
        r2.specialAbility();
        r2.showStats();

        System.out.println();

        r3.attack();
        r3.specialAbility();
        r3.showStats();

        System.out.println();

        BattleBot b1 = new BattleBot("Titan Warrior", 150, 70, 60);
        b1.upgradeWeapon();
        b1.upgradeArmor();

        System.out.println();

        ThunderBot t1 = new ThunderBot("Strom Breaker", 140, 75, 45);
        t1.upgradeWeapon();
        t1.upgradeArmor();
    }
}
