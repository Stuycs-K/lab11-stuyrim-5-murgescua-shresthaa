// code inside class not updated-still CodeWarrior code
public class Boss extends Adventurer {
  int calories, caloriesMax;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public Boss(String name, int hp){
    super(name,hp);
    caloriesMax = 22;
    calories = caloriesMax/2;
  }

  public Boss(String name){
    this(name,44);
  }

  public Boss(){
    this("Albert");
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "calories";
  }

  public int getSpecial(){
    return calories;
  }

  public void setSpecial(int n){
    calories = n;
  }

  public int getSpecialMax(){
    return caloriesMax;
  }

  /*Deal 5-10 damage to opponent, restores 3 calories*/
  public String attack(Adventurer other){
    int damage = (int)(Math.random()*6)+5;
    other.applyDamage(damage);
    restoreSpecial(3);
    return this + " launched cheeseburgers at "+ other + " and dealt "+ damage +
    " points of damage. They then replenish their energy with a cookie.";
  }

  /*Deal 6-15 damage to opponent, only if calories are high enough.
  *Reduces calries by 7.
  */
  public String specialAttack(Adventurer other){
    if(getSpecial() >= 7){
      setSpecial(getSpecial()-7);
      int damage = (int)(Math.random()*10+6);
      other.applyDamage(damage);
      return this + " forced "+other+" to eat their veggies, dealing "+ damage +" points of damage.";
    }else{
      return "Eat more, not enough calories to veggie attack. Instead "+attack(other);
    }

  }

  /*Restores 6 special and 3 hp to self.*/
  public String support(){
    int hp = 3;
    setHP(getHP()+hp);
    return this+" eats a pizza to restorea "+restoreSpecial(6)+" "
    + getSpecialName()+ " and "+hp+" HP";
  }
}
