public class SpiceEnthusiast extends Adventurer {
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
      return "sprays";
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
      int damage = (int) (Math.random() * 3) + 3;
      other.applyDamage(damage);
      restoreSpecial(2);
      return this + " throws spices at " + other + " and dealt " + damage
      + " points of damage. " + other + " tears up. ";
    }

    /*Deal 5-13 damage to opponent, only if sprays is high enough.
    *Reduces sprays by 6.*/
    public String specialAttack(Adventurer other){
      if (getSpecial() >= 6) {
        setSpecial(getSpecial() - 6);
        int damage = (int) ((Math.random() * 6) + (Math.random() * 6)) + 5;
        other.applyDamage(damage);
        return this + " used their gigantic pepper spray on " + other + ". Spiciness attacks "
        + other + " dealing " + damage + " points of damage. ";
      } else {
        return "Not enough sprays to use the gigantic pepper spray. Instead " + attack(other);
      }
    }

    /*Restores 4 special and 1 hp to self.*/
    public String support(){
      int hp = 1;
      setHP(getHP() + hp);
      return this + " drinks a bowl of hot flaming soup to reinvigorate " + restoreSpecial(4) + " "
      + getSpecialName() + " and " + hp + " HP. ";
    }

    /*Restores 6 special to other*/
    public String support(Adventurer other){
      return this + " gives a pack of spicy sticks to " + other + " and restores "
      + other.restoreSpecial(6) + " " + other.getSpecialName() + ". ";
    }
  }
