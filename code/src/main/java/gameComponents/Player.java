package src.main.java.gameComponents;


/**
 * Represents a player in the Santorini board game. Each player has a color (RED
 * or BLUE) and exactly two workers.
 */
public class Player {
	public boolean isFirstTurn = true;
	
	public int posWR1_x = 980;
	public int posWR1_y = 60;
	
	public int posWR2_x = 1020 ;
	public int posWR2_y = 60;
	
	public int posWB1_x = 980;
	public int posWB1_y = 60;
	
	public int posWB2_x = 1020;
	public int posWB2_y = 60;
	

	/** The two workers belonging to this player. */
<<<<<<< HEAD
	private Worker[] workers;
	private String name;
	
	/**
	 * Constructs a new Player, assigning RED or BLUE based on the next ID from
	 * {@link IDMaker}. Each player gets exactly two {@link Worker} objects.
	 */
	public Player(String name) {
		this.name = name;
		this.workers = new Worker[2];
		workers[0] = new Worker();
		workers[1] = new Worker();
=======
    private Worker[] workers;
    private String name;

    /**
     * Constructs a new Player, assigning RED or BLUE based on the next ID from {@link IDMaker}.
     * Each player gets exactly two {@link Worker} objects.
     */
    public Player(String name, PlayerColor color) {
    	this.color = color;
    	this.name=name;
        this.workers = new Worker[2];
        workers[0] = new Worker(color);
        workers[1] = new Worker(color);
    }

    // GETTERS
    
    /**
     * Returns this player's color.
     *
     * @return the {@link PlayerColor}.
     */
    public PlayerColor getColor() {
        return color;
    }
    public void setColor(PlayerColor color) {
		this.color = color;
>>>>>>> refs/remotes/origin/testAlpha0.1.1
	}

	// GETTERS
	/**
	 * Returns the two workers belonging to this player.
	 *
	 * @return an array of exactly two {@link Worker} objects.
	 */
	public Worker getWorker(int i) {
		return workers[i];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public boolean getPlayerFirtsTurn() {
		return isFirstTurn;
	}
	public void setPlayerFirtsPTurn(Boolean bol) {
		 this.isFirstTurn = bol;
	}

}