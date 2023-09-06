
import java.util.Random;
import java.util.Scanner;


public class RishiYalamanchili_Project5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Rishi Yalamanchili
		//ITSS.3311.003
		
		//Instantiate objects from Scanner (input), Game (game), and Session (session).
		
		Scanner input = new Scanner(System.in);
		Game game = new Game();
		Session session = new Session();
		
		
		//Declare Vars
		
		String playAgain; 
		
		//Invoke pre-game methods, session.getName and session.prtIntro.
		
		session.setName();
		session.prtIntro();
		
		input.next();
		
		//Initiate the do-while loop with variable playAgain
		
		do {
			session.setTurns();
			for (int count = 1;count <= session.getTurns(); count++) {
				System.out.println();
				System.out.println("*** TURN " + count + " ***");
				game.setDice();
				System.out.println("Dice Roll: " + game.getDie1() + "," + game.getDie2());
				System.out.println("Dice Sum: " + game.getSum());
				game.setPairBonus();
				game.getPairBonus();
				game.setSeven11Bonus();
				game.getSeven11Bonus();
				game.setTotal();
				
				System.out.println("Total Pts: " + game.getTotal());
				System.out.println(); 
			}
			
			System.out.print("Would you like to play again? Enter Y or N: ");
			playAgain = input.next();
			playAgain = playAgain.toUpperCase();
		} while (playAgain.equals("Y"));
		
		session.prtOutro(session.getName());	
		input.close();
	}
}



class Game {

	//declare vars
	private int die1;
	private int die2;
	private int sum;
	private int pairBonus;
	private int seven11Bonus;
	private int total;
	private int tempDie;
	
	//define constructors
	
	//define methods
	public void setDice() {
		Random random = new Random();
		setDie1(random.nextInt(6) + 1);
		setDie2(random.nextInt(6) + 1);
		setSum(getDie1() + getDie2());
	
	}
	
	private void sortDice() {
		if (getDie2() < getDie1()) {
			setTempDie(getDie1());	
			setDie1(getDie2());
			setDie2(getTempDie());
		}
	}
	
	

	public int getDie1() {
		return die1;
	}

	public void setDie1(int die1) {
		this.die1 = die1;
	}

	public int getDie2() {
		return die2;
	}

	public void setDie2(int die2) {
		this.die2 = die2;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getPairBonus() {
		return pairBonus;
	}

	public void setPairBonus() {
		if (getDie1() == getDie2()) {
			this.pairBonus = 6;
			System.out.println("Pair Bonus: 6");
		}
		else {
			this.pairBonus = 0;
			System.out.println("Pair Bonus: 0");
		}
		
	}

	public int getSeven11Bonus() {
		return seven11Bonus;
	}

	public void setSeven11Bonus() {
		if (getSum() == 7 || getSum() == 11) {
			this.seven11Bonus = 5;
			System.out.println("7-11 bonus: 5" );
		}
		else {
			this.seven11Bonus = 0;
			System.out.println("7-11 bonus: 0" );
			
		}
	}

	public int getTotal() {
		return total;
	}

	public void setTotal() {
		this.total = getSum() + getPairBonus() + getSeven11Bonus();
	}

	public int getTempDie() {
		return tempDie;
	}

	public void setTempDie(int tempDie) {
		this.tempDie = tempDie;
	}
}

class Session {
	//declare vars
	private String name;
	private int turns = 0;
		
	//define constructors
		
	//define methods
	public void setName() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter your name: "); 
		this.name = input.next();
	}
	
	public void prtIntro() {
		System.out.println();
		System.out.println("						  Hi, " + this.getName() + ", and Welcome to the 3311 Dice Game!");
		System.out.println("			    	  Playing the game is easy - just  \"roll\"  the dice and the computer does the rest.");
		System.out.println("				   The sum of the dice is worth points. You earn 5 bonus if you roll a 7 or a 11.");
		System.out.println("						  You earn 6 bonus points if you roll doubles. ");
		System.out.println("						 Now let's begin - enter any character to begin.");	
	}
	
	public String getName() {
		return name;
	}



	public int getTurns() {
		return turns;
	}

	

	public void setTurns() {
		System.out.print("Enter the number of turns you wish to play: ");
		Scanner input = new Scanner(System.in);
		this.turns = input.nextInt();
	}
	
	public void prtOutro(String name) {
		System.out.println("						  Thank you for playing 3311 dice game, " + name);
		System.out.println("							Come back and play again anytime!");
	}
}





