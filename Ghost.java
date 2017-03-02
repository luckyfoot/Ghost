import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Ghost {
	public static ArrayList<String> getWordsList() throws FileNotFoundException{
		FileInputStream inFile = new FileInputStream("wordFile.txt");
		Scanner wordsIn = new Scanner(inFile);
		ArrayList <String> wordsList = new ArrayList<String>() ;
		
		
		while (wordsIn.hasNext()){
			wordsList.add(wordsIn.next()) ;
		}
		wordsIn.close();
		
		return wordsList;
	}

	public static ArrayList<Player> CreatePlayer(int playerNum){
		ArrayList<Player> players = new ArrayList<Player>();
		int playerCount = playerNum;
		int i = 0;
		
		for (i = 0 ; i < playerCount; i++){
			players.add(new Player());
		}
		return players;		
	}

	public static void main(String[] args) throws IOException {
		Scanner userIn = new Scanner(System.in);
		ArrayList <String> listOfWords;
		ArrayList <Player> players = new ArrayList<Player>();
		boolean gameover = false;
		String theWord = "";
		int numPlayers = 0;
		int playerTurn = 0;
		int i =0;
		
		listOfWords = getWordsList();
		
		System.out.println("How many players?");
		numPlayers = userIn.nextInt();
		
		CreatePlayer(numPlayers);
		
		System.out.println("Think of a word");
		System.out.println("Type the first letter of the word:\n");
		theWord = userIn.next();
		playerTurn ++;
		
		while (gameover != true){
			System.out.println("The word so far is : \n\t" + theWord);
			System.out.println("Enter the next letter in the word");
			theWord += userIn.next();
			playerTurn++;
			
			if (theWord.length() > 3 && listOfWords.contains(theWord)){
				players.get(playerTurn).setGhost();
			}
			if (players.get(playerTurn).getGhost().length() > 0){
				System.out.println("Player " + playerTurn + "has " + players.get(playerTurn).getGhost());
			}
			if (playerTurn >= numPlayers){
				playerTurn = 0;
			}
			
		}
		
		}


	
	}

	
	


