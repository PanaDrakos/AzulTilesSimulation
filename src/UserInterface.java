import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
	private Scanner scanner;
	private ArrayList<Tile> factory;
	
	public UserInterface() {
		this.scanner = new Scanner(System.in);
		this.factory = new ArrayList<>();
	}
	
	public void start() {
		System.out.println("Welcome to Azul! \n");
		System.out.println("How many players?");
		TileBlue blue = new TileBlue(1, "Blue");
		TileRed red = new TileRed(2, "Red");
		TileYellow yellow = new TileYellow(3, "Yellow");
		TileBlack black = new TileBlack(4, "Black");
		TileWhite white = new TileWhite(5, "White");
		Collections.addAll(factory, blue, red, yellow, black, white);
		int players = 2;
		
		while (true) {
			int input = Integer.valueOf(scanner.nextLine());
			if (input < 2 || input > 4) {
				System.out.println("Incorrect input!");
			} else {
				players = input;
				break;
			}
		}
		
		int boards = 5;
		if (players == 3) {
			boards += 2;
		}
		if (players == 4) {
			boards+= 4;
		}
		
		System.out.println("Great! There are now " + boards + " factory displays. \n");
		System.out.println("Filling each factory display... \n");
		
		Random random = new Random();
		for (int i = 1; i <= boards; i++) {
			for (int x = 4; x > 0; x--) {
				int randomTile = random.nextInt(5) + 1;
				for (Tile tile: factory) {
					if (randomTile == tile.getId()) {
						if (tile.checkMax() != 0) {
							tile.increaseAmount();
						} else {
							x++;
						}
					}
				}
			}
			System.out.println("Board " + i + " has: ");
			for (Tile tile: factory) {
				System.out.println(tile);
			}
			System.out.println("\n");
			for (Tile tile: factory) {
				tile.resetAmount();
			}
			
		}
		
	}

}
