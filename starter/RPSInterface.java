/* 
  Name: Qingyang Hu
  Email: q3hu@ucsd.edu
  PID: A16164360
  Sources Used: Java Interface Documentation, PA1 Write-up
   
  This file is for CSE 12 PA1 in Winter 2023,
  and contains an interface definition of RPS of some basic functionalities.
*/

/**
 * An interface that specifies the functionality of RPS (Rock Paper Scissors)
 */
public interface RPSInterface {
    /**
     * Generates next cpu move
     *
     * @return representing the move, depending on random int
     */
    public String genCPUMove();

    /**
     * Takes the user move, the CPU move, and determines who wins.
     *
     * @param playerMove move of the player
     * @param cpuMove    move of the CPU
     * @return -1 for invalid move, 0 for tie, 1 for player win, 2 for cpu win
     */
    public int determineWinner(String playerMove, String cpuMove);

    /**
     * Determine if the move is valid
     *
     * @param move The move
     * @return true if the move is valid, false otherwise
     */
    public boolean isValidMove(String move);

    /**
     * Play one game of RPS.
     * Also adds appropriately to the number of games, wins and ties played.
     * and records the most recent moves.
     *
     * @param playerMove move of the player
     * @param cpuMove    move of the CPU
     */
    public void playRPS(String playerMove, String cpuMove);

    /**
     * Print out the end game stats: moves played and win percentages
     */
    public void displayStats();
}
