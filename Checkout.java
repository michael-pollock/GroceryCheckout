//Name: Michael Pollock
//Time: 180 min
//References: [1] http://euclid.nmu.edu/~mkowalcz/cs120/hwk3/DecimalExample.java

//POS program. Get num of items, add cost, ask if want bag, give total amount due

//Format prices
import java.text.DecimalFormat; // Reference [1], formatting a variable
import java.math.RoundingMode;

public class Checkout {
	public static void main(String[] args){

		//Print greeting
		ConsoleIO.printLine("Welcome to Risk or Reward Grocery's FAST LANE where you're in and out quick ONLY IF you have 1-10 items. ");

		//How many items? error for 0 or less, 11 or more.
		ConsoleIO.print("How many items do you have today? ");
		int itemNum = ConsoleIO.readInt();
		itemNum = CatchCheckout.verifyNumEx(itemNum, 0, 12);
		String refuse = "n";
		ConsoleIO.printLine("");

		//Accept too many items, but punish
		if (itemNum == 11){
			ConsoleIO.printLine("Too many items? In MY LANE?? You're going to jail!");
			ConsoleIO.print("Refuse? (y/n) ");
			refuse = ConsoleIO.readLine();
			refuse = CatchCheckout.eqls(refuse, "y", "n");
			ConsoleIO.printLine("");
		}
		if (refuse.equals("y") && Math.random()<.5){
			ConsoleIO.printLine("I will make an exception today, but you are now forced to live a life of shame. ");
		} else if (refuse.equals("y")){
			ConsoleIO.printLine("You have faught the law, but you have lost.");
			ConsoleIO.printLine("Welcome to jail.");
			ConsoleIO.printLine("| | | | | |");
			ConsoleIO.printLine("| | |.. | |");
			ConsoleIO.printLine("| | |(  | |");
			ConsoleIO.printLine("| | |~~ | |");
			ConsoleIO.printLine("| | | | | |");
			ConsoleIO.printLine("YOU LOSE!");
			return;
		} else if (refuse.equals("n") && itemNum > 10){
			ConsoleIO.printLine("Welcome to jail.");
			ConsoleIO.printLine("| | | | | |");
			ConsoleIO.printLine("| | |.. | |");
			ConsoleIO.printLine("| | |(  | |");
			ConsoleIO.printLine("| | |~~ | |");
			ConsoleIO.printLine("| | | | | |");
			ConsoleIO.printLine("YOU LOSE!");
			return;
		}

		//Set rounding mode
		DecimalFormat myFormatter;
		myFormatter = new DecimalFormat("0.00");
		myFormatter.setRoundingMode(RoundingMode.UP);

		//Create price for items purchased, tax built in.
		int j = 0;
		double totalPrice = 0;
		double itemPrice = 0;
		String ip = "";
		String tp = "";
		String scan = "";
		ConsoleIO.print("Please scan your first item by pressing enter. ");
		scan = ConsoleIO.readLine();

		//Disobediance means jail time.
		if (!scan.equals("")){
			ConsoleIO.printLine("");
			ConsoleIO.printLine("You should have simply hit enter without typing anything!");
			ConsoleIO.printLine("");
			ConsoleIO.printLine("Welcome to jail!");
			ConsoleIO.printLine("| | | | | |");
			ConsoleIO.printLine("| | |.. | |");
			ConsoleIO.printLine("| | |(  | |");
			ConsoleIO.printLine("| | |~~ | |");
			ConsoleIO.printLine("| | | | | |");
			ConsoleIO.printLine("YOU LOSE!");
			return;
		}
		ConsoleIO.printLine("");
		while (j < itemNum && scan.equals("")){
			j++;
			itemPrice = CatchCheckout.price();
			ip = myFormatter.format(itemPrice);
			totalPrice = totalPrice + itemPrice*1.06;
			ip = myFormatter.format(itemPrice);
			tp = myFormatter.format(totalPrice);
			ConsoleIO.printLine("Item "+j+" price: $"+ip);
			ConsoleIO.printLine("Current total (with tax): $"+tp);
			if (j != itemNum) {
				ConsoleIO.printLine("Hit enter to scan next item. Type 'STOP' if you have all the groceries you can afford. ");
				scan = ConsoleIO.readLine();
				scan = CatchCheckout.eqls(scan, "", "STOP");
				ConsoleIO.printLine("");
			} else if (j == itemNum){
				ConsoleIO.printLine("");
			}
		}


		//Ask if bag needed
		ConsoleIO.print("Would you like a bag? (non-refundable) (y/n) ");
		String bag = ConsoleIO.readLine();
		bag = CatchCheckout.eqls(bag, "y", "n");
		ConsoleIO.printLine("");

		//Add cost of bag
		if (bag.equals("y")){
			totalPrice = totalPrice = totalPrice + 100000;
			myFormatter = new DecimalFormat("000,000.00");
		}

		//Print total
		tp = myFormatter.format(totalPrice);
		ConsoleIO.printLine("Thank you for using Risk or Reward Grocery's FAST LANE.");
		ConsoleIO.printLine("Your total today is $"+tp+".");
		if (bag.equals("y")){
			ConsoleIO.printLine("If you're wondering where the extra $100,000 charge came from, it was the bag.");
		}
		ConsoleIO.print("We are happy to throw you into our in-house jail if you cannot pay. Would you prefer 'pay' or 'jail-time'? ");
		String pay = ConsoleIO.readLine();
		pay = CatchCheckout.eqls(pay, "pay", "jail-time");
		ConsoleIO.printLine("");
		if (pay.equals("pay")){
			ConsoleIO.printLine("Thanks, have a great day!");
		} else {
			ConsoleIO.printLine("Welcome to jail.");
			ConsoleIO.printLine("| | | | | |");
			ConsoleIO.printLine("| | |.. | |");
			ConsoleIO.printLine("| | |(  | |");
			ConsoleIO.printLine("| | |~~ | |");
			ConsoleIO.printLine("| | | | | |");
			ConsoleIO.printLine("You chose to be here!");
		}
	}
}