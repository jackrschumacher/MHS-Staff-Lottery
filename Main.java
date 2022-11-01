import java.util.*;
class Main {
  public static void main(String[] args) {
    //Powerball costs $2 per ticket
    //
    //5 numbers between 1-69
    //One additional number between 1-26
    //
    //Powerball: 1,200,000,000 - match all 5 and powerball

    //$1,000,000 - match 5
    //$50,000- match 4+powerball
    //$100 -match 4 +powerball
    //$7-match 3
    //$7-match 2 +powerball
    //$4-match 1 + powerball, 0 + powerball

    int[] myTicket = makeTicket();
    ArrayList<int[]> tickets = new Arraylist<Integer[]>();
    

    for(int i = 0; i < myTicket.length; i++)
    {
      System.out.println(myTicket[i]);
    }
  }

  public static int[] makeTicket(){
    int[] ticket = {0,0,0,0,0,0};
    int counter = 0;
    while(counter<6){
      int numToTry;
      if(counter <5){
        numToTry= (int)(Math.random()* 69 +1);
        boolean unique = true;
        for(int i = 0; i < counter; i++){
          if(ticket[i] == numToTry)
          {
            unique = false;
          }
        }
        if(unique){
          ticket[counter] = numToTry;
          counter++;
        }
      }
    
      else{
        numToTry = (int)(Math.random()*26 + 1);
        ticket[counter] = numToTry;
        counter++;
      }
    }

    return ticket;
  }
}