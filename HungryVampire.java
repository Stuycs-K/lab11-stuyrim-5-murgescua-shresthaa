public class HungryVampire extends Adventurer{
    int lifeblood, lifebloodMax;

    /*the other constructors ultimately call the constructor
    *with all parameters.*/
    public HungryVampire(String name, int hp){
      super(name,hp);
      lifebloodMax = 15;
      lifeblood = lifebloodMax/2;
    }

    public HungryVampire(String name){
      this(name,30);
    }

    public HungryVampire(){
      this("Morpheus");
    }

    public String getSpecialName(){
      return "lifeblood";
    }

    public int getSpecial(){
      return lifeblood;
    }

    public void setSpecial(int n){
      lifeblood = n;
    }

    public int getSpecialMax(){
      return lifebloodMax;
    }

    /*Deal 2-4 damage to opponent, restores 2 lifeblood*/
    public String attack(Adventurer other){
      int damage = (int)(Math.random()*3)+2;
      other.applyDamage(damage);
      restoreSpecial(2);
      return this + " attacked "+ other + " and dealt "+ damage +
      " points of damage. They then take a sip from their jug of lifeblood. ";
    }

    /*Deal 8 damage to opponent, only if lifeblood is high enough.
    *Reduces lifeblood by 5; increases hp by 2.
    */
    public String specialAttack(Adventurer other){
      if(getSpecial() >= 5){
        setSpecial(getSpecial()-5);
        setHP(getHP()+2);
        int damage = 8;
        other.applyDamage(damage);
        return this + " used their vampire moves to suck blood out of "+other+", dealing "+ damage +" points of damage. ";
      }else{
        return "Not enough lifeblood to use this ultimate attack. Instead "+attack(other);
      }
    }
    /*Restores 3 HP to other, loses 2 HP*/
    public String support(Adventurer other){
      other.setHP(other.getHP()+3);
      setHP(getHP()-2);
      return this + " gives condensed lifebloood smoothie to "+other+" and restores 3 HP to them at the cost of 2 HP. ";

    }
    /*Restores 6 special to self.*/
    public String support(){
      return this+" takes a juicy bite of a nearby wolf to restore "+restoreSpecial(6)+ " "
      + getSpecialName() + ". ";
    }
  }
