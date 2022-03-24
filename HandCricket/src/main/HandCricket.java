package main;

import java.util.Random;
import java.util.Scanner;

public class HandCricket {
	
	String name;
	int playingOrder; //1 for Bat First, 2 for Bowl First
	int target;
	int score;
	int ballsPlayed;
	int fours;
	int sixes;
	boolean status;
	
	public HandCricket(){
		this.name = "";
		this.playingOrder = 0;
		this.target = 0;
		this.score = 0;
		this.ballsPlayed = 0;
		this.fours = 0;
		this.sixes = 0;
		this.status = false;
	}
	
	public HandCricket(String name, int playingOrder, int target, int score, int ballsPlayed, int fours, int sixes,
			boolean status) {
		super();
		this.name = name;
		this.playingOrder = playingOrder;
		this.target = target;
		this.score = score;
		this.ballsPlayed = ballsPlayed;
		this.fours = fours;
		this.sixes = sixes;
		this.status = status;
	}
	
	public static void printDetails(HandCricket player) {
		System.out.println("Player name: " + player.name);
		System.out.print("Player playing order: ");
		if(player.playingOrder == 1) {
			System.out.println("Batted first");
		}
		else {
			System.out.println("Bowled first");
		}
		System.out.println("Player target: " + player.target);
		System.out.println("Player score: " + player.score);
		System.out.println("Player balls played: " + player.ballsPlayed);
		System.out.println("Player fours: " + player.fours);
		System.out.println("Player sixes: " + player.sixes);
		if(player.status == true) {
			System.out.println("Player status: Winner!");
		}
		else {
			System.out.println("Player status: Loser!");
		}
	}

	public int randomNumberGenerator(int limit) {
		Random random = new Random();
		int generatedValue = random.nextInt(limit) + 1;
		return generatedValue;
	}
	
	public boolean checkValidity(float playerValue) {
		if(playerValue < 1 || playerValue > 6) {
			System.out.println("\nThe value entered is out of bounds! Please enter a value between 1 and 6 only.\n");
			return false;
		}
		else {
			return true;
		}
	}
	
	public static void main(String[] args) {
		int option = 1;
		int overs = 0;
		int tossChoice = 0;
		int tossResult = 0;
		int runCounter = 0;
		int computerValue = 0;
		int playerValue = 0;
		int ballsPlayed = 0;
		int scannerValue = 0;
		Scanner sc = new Scanner(System.in);

		while(option != 0) {
			
			System.out.println("Hello!\nWelcome to the Virtual Hand-Cricket game.\n\nPlease choose an option:");
			System.out.println("1. Play!\n0. Exit\n");
						
			while(!sc.hasNextFloat()) {
				System.out.println("Please enter a valid option! Make sure to select the option number!\n");
				System.out.println("********************************************************************************\n");
				System.out.println("1. Play!\n0. Exit\n");
				sc.nextLine();
			}
			
			scannerValue = Math.round(sc.nextFloat());
												
			while(scannerValue != 1 && scannerValue != 0) {
				System.out.println("Please enter a valid option! Make sure to select the correct option number!\n");
				System.out.println("********************************************************************************\n");
				System.out.println("1. Play!\n0. Exit\n");
				sc.nextLine();
				scannerValue = Math.round(sc.nextFloat());
			}
			
			option = scannerValue;
			
			if(option == 0) {
				break;
			}
			
			HandCricket computer = new HandCricket("Computer",0,0,0,0,0,0,false);
			HandCricket player = new HandCricket();
			
			System.out.print("Please enter your username: ");
			
			player.name = sc.next();
			sc.nextLine();
			
			System.out.println("\nHow many overs would you like to play for, " + player.name + "? [Min: 1, Max: 20]");
			
			while(!sc.hasNextFloat()) {
				System.out.println("Please enter a valid number!\n");
				System.out.println("********************************************************************************\n");
				sc.nextLine();
			}
			
			scannerValue = Math.round(sc.nextFloat());
			
			while(scannerValue < 1 || scannerValue > 20) {
				System.out.println("Please enter a valid number between 1 and 20!\n");
				System.out.println("********************************************************************************\n");
				sc.nextLine();
				scannerValue = Math.round(sc.nextFloat());
			}
			
			overs = scannerValue;
			
			System.out.println("It's time for the toss! Choose an option, " + player.name + ":\n");
			System.out.println("1. Heads\n2. Tails\n");
			
			while(!sc.hasNextFloat()) {
				System.out.println("Please enter a valid option! Make sure to select the option number!\n");
				System.out.println("********************************************************************************\n");
				System.out.println("1. Heads\n2. Tails\n");
				sc.nextLine();
			}
			
			scannerValue = Math.round(sc.nextFloat());
			
			while(scannerValue != 1 && scannerValue != 2) {
				System.out.println("Please enter a valid option! Make sure to select the correct option number!\n");
				System.out.println("********************************************************************************\n");
				System.out.println("1. Heads\n2. Tails\n");
				sc.nextLine();
				scannerValue = Math.round(sc.nextFloat());
			}
			
			tossChoice = scannerValue;
			
			if(tossChoice == 1) {
				System.out.println("You've chosen Heads!\n");
			}	
			else {
				System.out.println("You've chosen Tails!\n");
			}
			
			tossResult = player.randomNumberGenerator(2);
			
			System.out.println("Toss in progress...\n");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(tossResult == 1) {
				System.out.print("It's Heads! ");
			}	
			else {
				System.out.print("It's Tails! ");
			}
			
			if(tossChoice == tossResult) {
				System.out.println("You won the toss!!!\n");
				System.out.println("Choose an Option:");
				System.out.println("1. Bat First\n2. Bowl First\n");
				
				while(!sc.hasNextFloat()) {
					System.out.println("Please enter a valid option! Make sure to select the option number!\n");
					System.out.println("********************************************************************************\n");
					System.out.println("1. Bat First\n2. Bowl First\n");
					sc.nextLine();
				}
				
				scannerValue = Math.round(sc.nextFloat());
				
				while(scannerValue != 1 && scannerValue != 2) {
					System.out.println("Please enter a valid option! Make sure to select the correct option number!\n");
					System.out.println("********************************************************************************\n");
					System.out.println("1. Bat First\n2. Bowl First\n");
					sc.nextLine();
					scannerValue = Math.round(sc.nextFloat());
				}
				
				player.playingOrder = scannerValue;
				
				if(player.playingOrder == 1) {
					computer.playingOrder = 2;
				}
				else {
					computer.playingOrder = 1;
				}
				
			}	
			else {
				System.out.println("You lost the toss!\n");
				System.out.println("The Computer is choosing the playing order...\n");
				
				player.playingOrder = player.randomNumberGenerator(2);
				
				if(player.playingOrder == 1) {
					computer.playingOrder = 2;
				}
				else {
					computer.playingOrder = 1;
				}
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if(player.playingOrder == 1) {
				System.out.println("You're going to bat first!\n");
			}
			else {
				System.out.println("You're going to bowl first!\n");
			}
			
			System.out.println("Let's play!!!!\n");
			System.out.println("***************");
			System.out.println(" FIRST INNINGS");
			System.out.println("***************\n");
			
			for(ballsPlayed = 0; ballsPlayed < (overs * 6); ballsPlayed++) {
				System.out.print("Enter your value: ");
				while(!sc.hasNextFloat()) {
					System.out.println("Please enter a valid number between 1 and 6!\n");
					System.out.println("********************************************************************************\n");
					sc.nextLine();
				}
				
				playerValue = Math.round(sc.nextFloat());
				computerValue = player.randomNumberGenerator(6);
				
				if(player.checkValidity(playerValue)){
					
					System.out.println("You Played: " + playerValue);
					System.out.println("Comp Played: " + computerValue);
					
					if(playerValue == computerValue) {
						System.out.println("\nOut!!!\n");
						ballsPlayed++;
						break;
					}
					else {
						if(player.playingOrder == 1) {
							runCounter += playerValue;
							if(playerValue == 4) {
								player.fours++;
							}
							if(playerValue == 6) {
								player.sixes++;
							}
							System.out.println("Your Outstanding Runs: " + runCounter);
						}
						else {
							runCounter += computerValue;
							if(computerValue == 4) {
								computer.fours++;
							}
							if(computerValue == 6) {
								computer.sixes++;
							}
							System.out.println("The Computer's Outstanding Runs: " + runCounter);
						}
						System.out.println("Balls Played: " + (ballsPlayed + 1));
						System.out.println("Balls Left: " + ((overs * 6) - (ballsPlayed + 1)) + "\n");
					}
				}
				else {
					ballsPlayed--;
				}
				
			}
			
			System.out.println("*** END OF FIRST INNINGS ***\n");
			
			if(player.playingOrder == 1) {
				System.out.println("Your Outstanding Runs: " + runCounter);
				System.out.println("Balls Played: " + ballsPlayed);
				System.out.println("Your total # of fours: " + player.fours);
				System.out.println("Your total # of sixes: " + player.sixes);
				player.ballsPlayed = ballsPlayed;
				player.score = runCounter;
				computer.target = player.score + 1;
				System.out.println("Target to defend: " + computer.target);
				System.out.println("\nYou're up to bowl next! Good luck defending :D\n");
			}
			else {
				System.out.println("The Computer's Outstanding Runs: " + runCounter);
				System.out.println("Balls Played: " + ballsPlayed);
				System.out.println("The Computer's total # of fours: " + computer.fours);
				System.out.println("The Computer's total # of sixes: " + computer.sixes);
				computer.ballsPlayed = ballsPlayed;
				computer.score = runCounter;
				player.target = computer.score + 1;
				System.out.println("Target to beat: " + player.target);
				System.out.println("\nYou're up to bat next! Good luck chasing :D\n");
			}
			
			runCounter = 0;
			
			System.out.println("****************");
			System.out.println(" SECOND INNINGS");
			System.out.println("****************\n");
			
			for(ballsPlayed = 0; ballsPlayed < (overs * 6); ballsPlayed++) {
				System.out.print("Enter your value: ");
				while(!sc.hasNextFloat()) {
					System.out.println("Please enter a valid number between 1 and 6!\n");
					System.out.println("********************************************************************************\n");
					sc.nextLine();
				}
				
				playerValue = Math.round(sc.nextFloat());
				computerValue = player.randomNumberGenerator(6);
				
				if(player.checkValidity(playerValue)){
					
					System.out.println("You Played: " + playerValue);
					System.out.println("Comp Played: " + computerValue);
					
					if(playerValue == computerValue) {
						System.out.println("\nOut!!!\n");
						ballsPlayed++;
						break;
					}
					else {
						if(player.playingOrder == 2) {
							runCounter += playerValue;
							if(playerValue == 4) {
								player.fours++;
							}
							if(playerValue == 6) {
								player.sixes++;
							}
							System.out.println("Your Outstanding Runs: " + runCounter);
							if(runCounter >= player.target) {
								ballsPlayed++;
								break;
							}
						}
						else {
							runCounter += computerValue;
							if(computerValue == 4) {
								computer.fours++;
							}
							if(computerValue == 6) {
								computer.sixes++;
							}
							System.out.println("The Computer's Outstanding Runs: " + runCounter);
							if(runCounter >= computer.target) {
								ballsPlayed++;
								break;
							}
						}
						System.out.println("Balls Played: " + (ballsPlayed + 1));
						System.out.println("Balls Left: " + ((overs * 6) - (ballsPlayed + 1)) + "\n");
					}
				}
				else {
					ballsPlayed--;
				}
				
			}
						
			System.out.println("\n*** END OF SECOND INNINGS ***\n");
			
			if(player.playingOrder == 2) {
				System.out.println("Your Outstanding Runs: " + runCounter);
				System.out.println("Balls Played: " + ballsPlayed);
				System.out.println("Your total # of fours: " + player.fours);
				System.out.println("Your total # of sixes: " + player.sixes);
				player.ballsPlayed = ballsPlayed;
				player.score = runCounter;
				computer.target = 0;
			}
			else {
				System.out.println("The Computer's Outstanding Runs: " + runCounter);
				System.out.println("Balls Played: " + ballsPlayed);
				System.out.println("The Computer's total # of fours: " + computer.fours);
				System.out.println("The Computer's total # of sixes: " + computer.sixes);
				computer.ballsPlayed = ballsPlayed;
				computer.score = runCounter;
				player.target = 0;
			}
			
			if(player.score >= computer.score) {
				player.status = true;
				computer.status = false;
				System.out.println("\nCongratulations! You won!!!\n");
			}
			else {
				player.status = false;
				computer.status = true;
				System.out.println("\nAw Snap!! You Lost :(\n");
			}
			
			System.out.println("***** Final Details *****\n");
			
			printDetails(player);
			
			System.out.println();
			
			printDetails(computer);
			
			System.out.println("\nGame is restarting...\n");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		sc.close();
		System.out.println("See you later! :D");
	}
}
