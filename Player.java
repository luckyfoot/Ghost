
public class Player {
	private String ghost = null;
	private boolean playerLose = false;

	public Player() {
		this.ghost = "";
	}
	public String getGhost() {
		return ghost;
		
	}
	public boolean setGhost(){
		switch (ghost) {
		case "":
			ghost = ghost.concat("g");
			break;
		case "g":
			ghost = ghost.concat("h");
			break;
		case "gh":
			ghost = ghost.concat("o");
			break;
		case "gho":
			ghost = ghost.concat("s");
			break;
		case "ghos":
			ghost = ghost.concat("t");
			playerLose = true;
			break;
		}
		return playerLose;
	}

}
