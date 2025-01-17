import java.util.*;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.WHITE;
  private static final int BORDER_BACKGROUND = Text.WHITE + Text.BACKGROUND;

  public static void main(String[] args) {
    run();

    /*
    // Testing game interface
    Text.clear();
    //player party
    Adventurer p1 = new CodeWarrior();
    Adventurer p2 = new SpiceEnthusiast();
    Adventurer p3 = new HungryVampire();
    ArrayList<Adventurer> partyexample = new ArrayList<Adventurer>();
    partyexample.add(createRandomAdventurer("Igret", "Califore", "Simone"));
    partyexample.add(createRandomAdventurer("Gorwn", "Corle", "Koelk"));
    partyexample.add(createRandomAdventurer("Okelp", "Sleocvb", "Woker"));
    drawParty(partyexample, 1);

    //enemy party
    Adventurer e1 = new CodeWarrior("Enemy 1", 30);
    Adventurer e2 = new SpiceEnthusiast("Enemy 2", 30);
    Adventurer e3 = new HungryVampire("Enemy 3", 30);
    ArrayList<Adventurer> partyexample2 = new ArrayList<Adventurer>();
    partyexample2.add(createRandomAdventurer());
    partyexample2.add(createRandomAdventurer());
    partyexample2.add(createRandomAdventurer());
    drawParty(partyexample2, 24);
    */

    // Tests for colorByPercent()
    // Text.go(5,1);
    // System.out.print(colorByPercent(p1.getHP(), p1.getmaxHP()));//white
    // System.out.print(colorByPercent(7, 25)); //yellow
    // System.out.print(colorByPercent(6, 25)); //red
    // Text.reset();

    /*
    Text.clear();
    Text.go(1,1);
    System.out.println("Welcome to... FOOD FIGHT!");
    System.out.print("Directions: You, commander of the three heroes, must fight against the monsters in the arena and expand your prestige. Do you want to choose the heroes' names? (y/n)  ");
    // CHANGE X Y OF CHOOSENAME BC IT CHANGES BASED ON TERMINAL SIZE -- DO AFTER TEXTBOX() AND DRAWTEXT()
    Scanner scan  = new Scanner(System.in);
    String chooseName = userInput(scan, 4, 7);
    if (chooseName.equals("y")) {
      String str = "Okay! Type in your first hero's name: ";
      drawText(str, 5, 1);
      String name1 = userInput(scan, 5, str.length() + 1);

      str = "Type in your second hero's name: ";
      System.out.print(str);
      String name2 = userInput(scan, 6, str.length() + 1);

      str = "Type in your third hero's name: ";
      System.out.print(str);
      String name3 = userInput(scan, 7, str.length() + 1);
    }
    else if (chooseName.equals("n")) {
      System.out.print("Okay! Your heroes' names are: ");
    }
    else {
      System.out.println("Please type a valid input. (y/n) ");
    }
    */

    /*
    // 1-1000 fills up all the space at around 160-ish
    // testing for overflow and rewriting
    String str = "";
    for (int i = 1; i <= 1000; i++) {
      str += "" + i;
    }
    TextBox(5,1,80,18,str);

    //TextBox() test for str of integers 1-100
    str = "";
    for (int i = 1; i <= 100; i++) {
      str += "" + i;
    }
    TextBox(5,1,80,18,str);
    */

    //drawBackground();
  }

  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appear or parties will appear.
  public static void drawBackground(){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    // player line
    Text.go(4, 1);
    System.out.print(Text.colorize(BORDER_COLOR + BORDER_BACKGROUND));
    for (int i = 0; i < 80; i++) {
      System.out.print("-");
    }
    for (int idx = 1; idx < 4; idx++) {
      Text.go(idx, 29);
      System.out.println("|");
      Text.go(idx, 59);
      System.out.println("|");
    }

    // opponent line
    Text.go(23, 1);
    for (int i = 0; i < 80; i++) {
      System.out.print("-");
    }
    Text.go(24,1);
    for (int idx = 24; idx < 27; idx++) {
      Text.go(idx, 29);
      System.out.println("|");
      Text.go(idx, 59);
      System.out.println("|");
    }

    // command line
    Text.go(27, 1);
    for (int i = 0; i < 80; i++) {
      System.out.print("-");
    }
    Text.reset();
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }



  //Display a line of text starting at
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.
  public static void drawText(String s,int startRow, int startCol){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    Text.go(startRow, startCol);
    System.out.print(s);
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner of the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
  public static void TextBox(int row, int col, int width, int height, String text){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    int row2 = row;
    while (text.length() > 0 && row2 < row + height) {
      if (text.length() > width) {
        Text.go(row2, col);
        drawText(text.substring(0, width), row2, col);
        text = text.substring(width);
      } else {
        String space = "";
        for (int i = text.length(); i < width; i++) {
          space += " ";
        }
        drawText(text + space, row2, col);
        text = "";
      }
      row2++;
    }
    while (row2 < row + height) {
      Text.go(row2, col);
      for (int i = 1; i < width + 1; i++) {
        drawText(" ", row2, i);
      }
      row2++;
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

    //return a random adventurer (choose between all available subclasses)
    //feel free to overload this method to allow specific names/stats.
    public static Adventurer createRandomAdventurer(){
      ArrayList<Adventurer> adventurers = new ArrayList<Adventurer>();
      Adventurer a1 = new CodeWarrior("Hubert"+(int)(Math.random()*100));
      Adventurer a2 = new SpiceEnthusiast("Emily"+(int)(Math.random()*100));
      Adventurer a3 = new HungryVampire("Count"+(int)(Math.random()*100));
      adventurers.add(a1);
      adventurers.add(a2);
      adventurers.add(a3);
      Random rng = new Random();
      int idx = rng.nextInt(3);
      return adventurers.get(idx);
    }

    public static Adventurer createRandomAdventurer(String name1, String name2, String name3){
      ArrayList<Adventurer> adventurers = new ArrayList<Adventurer>();
      Adventurer a1 = new CodeWarrior(name1);
      Adventurer a2 = new SpiceEnthusiast(name2);
      Adventurer a3 = new HungryVampire(name3);
      adventurers.add(a1);
      adventurers.add(a2);
      adventurers.add(a3);
      Random rng = new Random();
      int idx = rng.nextInt(3);
      return adventurers.get(idx);
    }

    /*Display a List of 2-4 adventurers on the rows row through row+3 (4 rows max)
    *Should include Name HP and Special on 3 separate lines.
    *Note there is one blank row reserved for your use if you choose.
    *Format:
    *Bob          Amy        Jun
    *HP: 10       HP: 15     HP:19
    *Caffeine: 20 Mana: 10   Snark: 1
    * ***THIS ROW INTENTIONALLY LEFT BLANK***
    */
    public static void drawParty(ArrayList<Adventurer> party,int startRow){
      /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
      Text.go(1,1);
      for (int i = 0; i < party.size(); i++) { //for each member
          Text.go(startRow, i*30);
          System.out.print(party.get(i).getName());
          Text.go(startRow+1, i*30);

          //HP changes colors
          System.out.print("HP: ");
          System.out.print(colorByPercent(party.get(i).getHP(), party.get(i).getmaxHP()));
          Text.reset();

          Text.go(startRow+2, i*30);
          System.out.print(party.get(i).getSpecialName() + ": " + party.get(i).getSpecial());
      }
      /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    }

    public static void drawEnemyParty(ArrayList<Adventurer> party,int startRow){
      /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
      Text.go(24,1);
      for (int i = 0; i < party.size(); i++) { //for each member
          Text.go(startRow, i*30);
          System.out.print(party.get(i).getName());
          Text.go(startRow+1, i*30);

          //HP changes colors
          System.out.print("HP: ");
          System.out.print(colorByPercent(party.get(i).getHP(), party.get(i).getmaxHP()));
          Text.reset();

          Text.go(startRow+2, i*30);
          System.out.print(party.get(i).getSpecialName() + ": " + party.get(i).getSpecial());
      }
      /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    }


  //Use this to create a colorized number string based on the % compared to the max value.
  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    // under 25% : red
    if (((double) hp)/ maxHP < 0.25) {
      System.out.print(Text.colorize(Text.RED));
    }
    // under 75% : yellow
    else if (((double) hp)/ maxHP < 0.75) {
      System.out.print(Text.colorize(Text.YELLOW));
    }
    // otherwise : white
    else {
      System.out.print(Text.colorize(Text.WHITE));
    }
    return output;
  }





  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(ArrayList<Adventurer> party, ArrayList<Adventurer> enemies){

    drawBackground();

    drawParty(party, 1);

    drawEnemyParty(enemies, 24);
  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location
      Text.hideCursor();
      Text.go(1,1);

      //show cursor
      Text.showCursor();
      String input = in.nextLine();

      //clear the text that was written
      Text.clear();
      return input;
  }

  public static String userInput(Scanner in, int x, int y){
      //Move cursor to prompt location
      Text.hideCursor();
      Text.go(x, y);

      //show cursor
      Text.showCursor();
      String input = in.nextLine();

      return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }

  public static void run(){
    //Clear and initialize
    Text.hideCursor();
    Text.clear();


    //Things to attack:
    //Make an ArrayList of Adventurers and add 1-3 enemies to it.
    //If only 1 enemy is added it should be the boss class.
    //start with 1 boss and modify the code to allow 2-3 adventurers later.
    ArrayList<Adventurer> enemies = new ArrayList<Adventurer>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    int x = (int)(Math.random()*4);
    if (x == 0){
      Adventurer boss = new Boss();
      enemies.add(boss);
    }
    else if (x == 1){
      enemies.add(createRandomAdventurer());
      enemies.add(createRandomAdventurer());
    }
    else {
      enemies.add(createRandomAdventurer());
      enemies.add(createRandomAdventurer());
      enemies.add(createRandomAdventurer());
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    int z = (int)(Math.random()*3)+2;
    if (z == 2){
      party.add(createRandomAdventurer("Igret", "Califore", "Simone"));
      party.add(createRandomAdventurer("Lidia", "Abdo", "Marianne"));
    }
    /* else if (x == 3){
      party.add(createRandomAdventurer("Ilhim", "William", "Coral"));
      party.add(createRandomAdventurer("Violet", "Matthew", "Evelyn"));
    }
    */
    else {
      party.add(createRandomAdventurer("Amos", "Narine", "Hamid"));
      party.add(createRandomAdventurer("Lavinia", "Juhan", "Medea"));
      party.add(createRandomAdventurer("Mikael", "Marcela", "Eochaid"));
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    ArrayList<Adventurer> deadParty = new ArrayList<>();
    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    String input = "";//blank to get into the main loop.
    Scanner in = new Scanner(System.in);
    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen(party, enemies);//initial state.

    //Main loop

    //display this prompt at the start of the game.
    String preprompt = "Enter command for "+party.get(whichPlayer)+": attack(a)/special(sp)/support(su)/quit(q)";
    drawText(preprompt, 28, 1);
    String text = "";

    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      //Read user input
      input = userInput(in, 29, 1);

      //example debug statment
      //TextBox(24,2,1,78,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );

      //display event based on last turn's input
      if(partyTurn){

        //Process user input for the last Adventurer:
        if(input.equals("attack") || input.equals("a")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          text += party.get(whichPlayer).attack(enemies.get(whichOpponent));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.equals("special") || input.equals("sp")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
           text += party.get(whichPlayer).specialAttack(enemies.get(whichOpponent));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.startsWith("su ") || input.startsWith("support ")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su  is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          int playerSupported = Integer.valueOf(input.substring(input.length() - 1));
          text += party.get(whichPlayer).support(party.get(playerSupported));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }

        TextBox(28, 1, 80, 2, " ");
        TextBox(5, 1, 80, 18, text);

        //You should decide when you want to re-ask for user input
        //If no errors:
        whichPlayer++;

        if(whichPlayer < party.size()){
          //This is a player turn.
          //Decide where to draw the following prompt:
          String prompt = "Enter command for "+party.get(whichPlayer)+": attack(a)/special(sp)/support(su)/quit(q)";
          drawText(prompt, 28, 1);

        } else {
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          String prompt = "Press ENTER to see monster's turn";
          drawText(prompt, 28, 1);
          partyTurn = false;
          whichOpponent = 0;
        }
        //done with one party member
      }else{
        //not the party turn!
        String enemyText = "";

        //enemy attacks a randomly chosen person with a randomly chosen attack.
        //Enemy action choices go here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
        //YOUR CODE HERE
        if (enemies.size() > whichOpponent) {
          for (int enemymate = 0; enemymate < enemies.size(); enemymate++) {
            Adventurer enemymateAdv = enemies.get(enemymate);
            if (enemymateAdv.getHP() < (enemymateAdv.getmaxHP() * 0.2)) {
              enemyText += enemies.get(whichOpponent).support(enemymateAdv);
            }
            else {
              int randomHero = (int) (Math.random() * party.size());
              enemyText += enemies.get(whichOpponent).attack(party.get(randomHero));
            }
            whichOpponent++;
          }
        }
        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        System.out.print(Text.colorize(Text.RED));
        TextBox(5, 1, 80, 18, enemyText);

        System.out.print(Text.colorize(BORDER_COLOR));
        //Decide where to draw the following prompt:
        TextBox(28, 1, 80, 2, " ");
        String prompt = "Press ENTER to see next turn";
        drawText(prompt, 28, 1);

      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichPlayer = 0;
        turn++;
        partyTurn=true;
        //display this prompt before player's turn
        String prompt = "Enter command for "+party.get(whichPlayer)+": attack(a)/special(sp)/support(su)/quit(q)";
        drawText(prompt, 28, 1);
      }

      //display the updated screen after input has been processed.
      drawScreen(party, enemies);


    }//end of main game loop


    //After quit reset things:
    quit();
  }
}
