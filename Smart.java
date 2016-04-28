import java.util.*;
import java.util.concurrent.*;
import java.security.*;
import java.lang.*;

public class Smart {
	private static RoomManager rm = new RoomManager();
	static boolean game = true;
	
	private static int playerHealth = 100;
	private static int playerDamage = 3;
	private static int chanceToRun = 43;
	
	static int x = rm.getStartRoom().getX();
	static int y = rm.getStartRoom().getY();
	public static void main(String args[]){
		//cls();
		//System.out.println(rm.getRoomAt(x, y).getInfo());
		try {
			System.out.println("Random Room Generator Loading...");
			Thread.sleep(500);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("Random Room Generator Loaded Successfully");
		for(int i = 1; i<=4; i++) {
			for(int j = 1; j<=4; j++) {
				System.out.print("" + rm.getRoomAt(i,j).getInfo().charAt(0) + "" + rm.getRoomAt(i, j).getInfo().charAt(1) + "       ");
			}
			System.out.println();
		}
		boolean game = true;
		while (game) {
			Scanner scanner = new Scanner(System.in);
			String userInput = scanner.nextLine();
			
			switch (userInput.toLowerCase())
			{
				case "walk forward": case "move forward": case "go forward": case "forward": {
					if (x != 1) {
						x--;
						cls();
						System.out.println(rm.getRoomAt(x, y).getInfo());
					} else {
						cls();
						System.out.println("You can't walk forwards." );
						try {
							Thread.sleep(2000);
						} catch(InterruptedException ex) {
							Thread.currentThread().interrupt();
						}
						genCoordinates();
					}
					break;
				}
					
				case "walk backwards": case "move backwards": case "go backwards": case "backwards": {
					if (x != 4) {
						x++;
						cls();
						System.out.println(rm.getRoomAt(x, y).getInfo());
					} else{
						cls();
						System.out.println("You can't walk backward.");
						try {
							Thread.sleep(2000);
						} catch(InterruptedException ex) {
							Thread.currentThread().interrupt();
						}
						System.out.println(rm.getRoomAt(x, y).getInfo());
					}
					break;
				}
					
				case "walk left": case "move left": case "go left": case "left": {
					if (y != 1) {
						y--;
						cls();
						System.out.println(rm.getRoomAt(x, y).getInfo());
					} else {
						cls();
						System.out.println("You can't walk to your left.");
						try {
							Thread.sleep(2000);
						} catch(InterruptedException ex) {
							Thread.currentThread().interrupt();
						}
						System.out.println(rm.getRoomAt(x, y).getInfo());
					}
					break;
				}
					
				case "walk right": case "move right": case "go right": case "right": {
					if (y != 4) {
						y++;
						cls();
						System.out.println(rm.getRoomAt(x, y).getInfo());
					} else { 
						cls();
						System.out.println("You can't walk to your right.");
						try {
							Thread.sleep(2000);
						} catch(InterruptedException ex) {
							Thread.currentThread().interrupt();
						}
						genCoordinates();
					}
					break;
				}
				
				case "dance": {
					System.out.println("Dubstep music plays faintly in the background.");
					System.out.println("You can't help but dance... Wait... I CAN'T STOP!");
					System.out.println("You die of dehydration due to dancing too much.");
					System.out.println("Your skeleton still dances to this day...");
					game = false;
					break;
				}
					
				case "help": {
					System.out.println("Commands: Walk/Go/Move right/left/backwards/forward");
					System.out.println("Example: walk backwards OR go forward");
					try {
						Thread.sleep(8000);
					} catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}
					genCoordinates();
					break;
				}
					
				default:  {
					System.out.println("Error 404: Unknown Command");
					System.out.println("Type 'help' for a list of commands.");
					try {
						Thread.sleep(8000);
					} catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}
					genCoordinates();
				}
			}
		}
		System.exit(0);
	}
	
	private static void genCoordinates() {
		cls();
		System.out.println(rm.getRoomAt(x, y).getInfo());
		System.out.print("> ");
	}
	
	
	
	private static void cls() {
		for(int i=0; i<=1000; i++){
			System.out.println();
		}
	}
	
	private static void credits() {
		System.out.println("This game was made by Maeyrl for a two month long project. "); // AND THE HELP OF A FRIEND
		System.out.println("Your game will restart in 15 seconds.");		
		try {
			Thread.sleep(15000);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		x=4;
		y=1;
		cls();
		game=true;
		genCoordinates();

	}
}
