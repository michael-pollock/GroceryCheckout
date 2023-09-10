public class CatchCheckout {
	//exclusive high and low limiter
	public static int verifyNumEx(int userIn, int lowerLimit, int upperLimit){
		while (userIn <= lowerLimit || userIn >= upperLimit){
			ConsoleIO.print("Please enter a number from "+(lowerLimit+1)+" to "+(upperLimit-1)+": ");
			userIn = ConsoleIO.readInt();
		}
		return userIn;
	}
	//inclusive high and low limiter
	public static int verifyNumIn(int userIn, int lowerLimit, int upperLimit){
		return verifyNumEx(userIn, lowerLimit-1, upperLimit+1);
	}
	//Valid string input check for 2 possible entries
	public static String eqls(String userIn, String check1, String check2){
		while (!userIn.equals(check1) && !userIn.equals(check2)){
			ConsoleIO.print("Please select either '"+check1+"' or '"+check2+"': ");
			userIn = ConsoleIO.readLine();
		}
		return userIn;
	}
	public static double price(){
		double price = Math.random()*75;
		return price;
	}
}