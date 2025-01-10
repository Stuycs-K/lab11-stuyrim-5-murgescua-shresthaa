public class SpiceEnthusiast extends Adventurer{
    int sprays, spraysMax;

    /*the other constructors ultimately call the constructor
    *with all parameters.*/
    public SpiceEnthusiast(String name, int hp){
      super(name,hp);
      spraysMax = 20;
      sprays = spraysMax/2;
    }

    public SpiceEnthusiast(String name){
      this(name,21);
    }

    public SpiceEnthusiast(){
      this("Seifer");
    }

    /*The next 8 methods are all required because they are abstract:*/
    public String getSpecialName(){
      return "Sprays";
    }

    public int getSpecial(){
      return sprays;
    }

    public void setSpecial(int n){
      sprays = n;
    }

    public int getSpecialMax(){
      return spraysMax;
    }

    /*Deal 3-5 damage to opponent, restores 2 sprays*/
    public String attack(Adventurer other){
      int damage = (int)(Math.random()*6)+2;
      other.applyDamage(damage);
      restoreSpecial(2);
      return this + " attacked "+ other + " and dealt "+ damage +
      " points of damage. They then take a sip of their coffee.";
    }

    /*Deal 5-13 damage to opponent, only if sprays is high enough.
    *Reduces sprays by 6.*/
    public String specialAttack(Adventurer other){
      if(getSpecial() >= 8){
        setSpecial(getSpecial()-8);
        int damage = (int)(Math.random()*5+Math.random()*5)+3;
        other.applyDamage(damage);
        return this + " used their "+preferredLanguage+
        " skills to hack the matrix. "+
        " This glitched out "+other+" dealing "+ damage +" points of damage.";
      }else{
        return "Not enough caffeine to use the ultimate code. Instead "+attack(other);
      }

    }

    /*Restores 4 special and 1 hp to self.*/
    public String support(){
      int hp = 1;
      setHP(getHP()+hp);
      return this+" drinks a coffee to restores "+restoreSpecial(6)+" "
      + getSpecialName()+ " and "+hp+" HP";
    }

    /*Restores 6 special to other*/
    public String support(Adventurer other){
      return "Gives a coffee to "+other+" and restores "
      + other.restoreSpecial(5)+" "+other.getSpecialName();
    }
  }
