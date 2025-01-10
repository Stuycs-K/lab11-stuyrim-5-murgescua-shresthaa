public class HungryVampire extends Adventurer{
    int lifeblood, lifebloodMax;

    /*the other constructors ultimately call the constructor
    *with all parameters.*/
    public CodeWarrior(String name, int hp){
      super(name,hp);
      lifebloodMax = 15;
      lifeblood = lifebloodMax/2;
    }

    public CodeWarrior(String name, int hp){
      this(name,hp,"c++");
    }

    public CodeWarrior(String name){
      this(name,30);
    }

    public CodeWarrior(){
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
      " points of damage. They then take a sip from their jug of lifeblood.";
    }

    /*Deal 8 damage to opponent, only if lifeblood is high enough.
    *Reduces lifeblood by 5; increases hp by 2.
    */
    public String specialAttack(Adventurer other){
      if(getSpecial() >= 8){
        setSpecial(getSpecial()-5);
        setHP(getHP()+2);
        int damage = 8;
        other.applyDamage(damage);
        return this + " used their vampire moves to suck the blood out of"+other+" dealing "+ damage +" points of damage.";
      }else{
        return "Not enough lifeblood to use this ultimate attack. Instead "+attack(other);
      }

    }
    /*Restores 5 special to other*/
    public String support(Adventurer other){
      return "Gives a coffee to "+other+" and restores "
      + other.restoreSpecial(5)+" "+other.getSpecialName();
    }
    /*Restores 6 special and 1 hp to self.*/
    public String support(){
      int hp = 1;
      setHP(getHP()+hp);
      return this+" drinks a coffee to restores "+restoreSpecial(6)+" "
      + getSpecialName()+ " and "+hp+" HP";
    }
  }
