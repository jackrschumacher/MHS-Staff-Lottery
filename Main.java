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

    public static int[] makeTicket(){
      int[] ticket = {0,0,0,0,0,0};
      int counter = 0;
      while(counter<6){
        int numToTry;
        if(counter <5){
          numToTry= (int)(Math.random()* 69 +1);
        }
        else{
          numToTry = (int)(Math.random()*26 + 1);
        }
      }
    }
    
  }
}