import java.util.*;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.WHITE + Text.BACKGROUND;

  public static void main(String[] args) {
    //run();

    // Testing game interface
    /*
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
    drawParty(partyexample2, 27);

    // Tests for colorByPercent()
    // Text.go(5,1);
    // System.out.print(colorByPercent(p1.getHP(), p1.getmaxHP()));//white
    // System.out.print(colorByPercent(7, 25)); //yellow
    // System.out.print(colorByPercent(6, 25)); //red
    // Text.reset();

    drawBackground();
    */

    Text.clear();
    Text.go(1,1);
    System.out.println("Welcome to... FOOD FIGHT!");
    System.out.print("Directions: You, commander of the three heroes, must fight against the monsters in the arena and expand your prestige. Do you want to choose the heroes' names? (y/n)  ");
    // CHANGE X Y OF CHOOSENAME BC IT CHANGES BASED ON TERMINAL SIZE -- DO AFTER TEXTBOX() AND DRAWTEXT()
    Scanner scan  = new Scanner(System.in);
    String chooseName = userInput(scan, 4, 7);
    if (chooseName.equals("y")) {
      String str = "Okay! Type in your first hero's name: ";
      System.out.print(str);
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
    Text.go(26, 1);
    for (int i = 0; i < 80; i++) {
      System.out.print("-");
    }
    Text.go(30,1);
    for (int idx = 27; idx < 30; idx++) {
      Text.go(idx, 29);
      System.out.println("|");
      Text.go(idx, 59);
      System.out.println("|");
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
  public static void drawScreen(){

    drawBackground();

    //drawParty();

    //draw enemy party

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
    ArrayList<Adventurer>enemies = new ArrayList<Adventurer>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    Random rng = new Random();
    int x = rng.nextInt(3);
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
    //YOUR CODE HERE
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    String input = "";//blank to get into the main loop.
    Scanner in = new Scanner(System.in);
    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen();//initial state.

    //Main loop

    //display this prompt at the start of the game.
    String preprompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";

    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      //Read user input
      input = userInput(in);

      //example debug statment
      TextBox(24,2,1,78,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );

      //display event based on last turn's input
      if(partyTurn){

        //Process user input for the last Adventurer:
        if(input.equals("attack") || input.equals("a")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.equals("special") || input.equals("sp")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.startsWith("su ") || input.startsWith("support ")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su  is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }

        //You should decide when you want to re-ask for user input
        //If no errors:
        whichPlayer++;


        if(whichPlayer < party.size()){
          //This is a player turn.
          //Decide where to draw the following prompt:
          String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";


        }else{
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          String prompt = "press enter to see monster's turn";

          partyTurn = false;
          whichOpponent = 0;
        }
        //done with one party member
      }else{
        //not the party turn!


        //enemy attacks a randomly chosen person with a randomly chosen attack.z`
        //Enemy action choices go here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
        //YOUR CODE HERE
        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/


        //Decide where to draw the following prompt:
        String prompt = "press enter to see next turn";

        whichOpponent++;

      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichPlayer = 0;
        turn++;
        partyTurn=true;
        //display this prompt before player's turn
        String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
      }

      //display the updated screen after input has been processed.
      drawScreen();


    }//end of main game loop


    //After quit reset things:
    quit();
  }
}
