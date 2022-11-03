import java.util.*;

class Main {
  public static void main(String[] args) {
    // Powerball costs $2 per ticket
    //
    // 5 numbers between 1-69
    // One additional number between 1-26
    //
    // Powerball: 1,200,000,000 - match all 5 and powerball

    // $1,000,000 - match 5
    // $50,000- match 4+powerball
    // $100 -match 4 +powerball
    // $7-match 3
    // $7-match 2 +powerball
    // $4-match 1 + powerball, 0 + powerball
    Scanner input = new Scanner(System.in);

    int[] jackpot = makeTicket();

    int[] myTicket = makeTicket();
    ArrayList<int[]> tickets = new ArrayList<int[]>();

    System.out.println("How much money would you like to put into the lottery?");
    int amountWanted = input.nextInt();
    int differenceAmount = 0;
    
    int counter = 0;
    while (counter < amountWanted) {
      tickets.add(makeTicket());
      counter++;
    }

    int totalWinnings = 0;
    for (int i = 0; i < tickets.size(); i++) {
      totalWinnings += moneyWon(tickets.get(i), jackpot);
    }
    System.out.println("You get: "+totalWinnings+" Dollars back.");
    differenceAmount = totalWinnings - amountWanted;
    System.out.println("Your difference is "+differenceAmount+"Dollars");
  }

  public static int[] makeTicket() {
    int[] ticket = { 0, 0, 0, 0, 0, 0 };
    int counter = 0;
    while (counter < 6) {
      int numToTry;
      if (counter < 5) {
        numToTry = (int) (Math.random() * 69 + 1);
        boolean unique = true;
        for (int i = 0; i < counter; i++) {
          if (ticket[i] == numToTry) {
            unique = false;
          }
        }
        if (unique) {
          ticket[counter] = numToTry;
          counter++;
        }
      }

      else {
        numToTry = (int) (Math.random() * 26 + 1);
        ticket[counter] = numToTry;
        counter++;
      }
    }

    return ticket;
  }

  public static int moneyWon(int[] ticket, int[] winner) {
    int regularMatches = 0;
    int jackpotMatch = 0;

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (ticket[i] == winner[j]) {
          regularMatches++;
        }
      }
    }
    if (ticket[5] == winner[5]) {
      jackpotMatch++;
    }
    if (regularMatches == 5 && jackpotMatch == 1) {
      return 1200000000;
    } else if (regularMatches == 5 && jackpotMatch == 0) {
      return 1000000;
    } else if (regularMatches == 4 && jackpotMatch == 1) {
      return 500000;
    } else if (regularMatches == 4 && jackpotMatch == 0
        || regularMatches == 3 && jackpotMatch == 1) {
      return 100;
    } else if (regularMatches == 3 && jackpotMatch == 0
        || regularMatches == 2 && jackpotMatch == 1) {
      return 7;
    } else if (regularMatches == 1 && jackpotMatch == 1
        || regularMatches == 0 && jackpotMatch == 1) {
      return 4;
    } else {
      return 0;

    }
  }
}