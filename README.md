


# CSE 12 PA1: Getting Comfortable in Java Again

**Due Date: Thursday, January 19, 2023, 11:59 pm PST**


### Learning goals:



* Affirm your commitment to upholding academic integrity in this course
* Get (re)set up to program in Java
* Run tests using JUnit
* Write and run a Java program that uses inheritance
* Submit code to Gradescope


### Submission:

You will submit this assignment in three parts. All are required before the deadline:



* Two Google Form submissions
* A Gradescope submission


## Part 1: Pre-Survey (5 points)

Complete a short [pre-survey here](https://forms.gle/q3hkhinHXyRE4vSdA).  This will help us understand your needs and better tailor the class to meet them.  


## Part 2: Academic Integrity (5 points)

Carefully read the integrity policy for this course, which is found in the Syllabus, and complete the [Integrity Pledge](https://forms.gle/AmQ46fzFL92xDpET8) from the syllabus.  

(Note that this is the same link from the Syllabus, so you might have already completed it.  If you have, you have already submitted this part of the assignment.)


## Part 3: Set up and choose your programming environment

In this class, you may use any programming environment that you choose, but you must be able to write, compile and run Java programs and JUnit tests.  You have the choice of setting up your own machine, or using your CSE 12 account in the lab or on the cloud labs.  We assume that you are comfortable writing and running Java, but if you need help getting set up, please come see a tutor for assistance.  



1. Download the starter code this repository by clicking on "<> Code" -> "Download ZIP" and put it in a directory in your working environment. 

   Alternatively, you can create a **private** repository by clicking on "Use this template", if you'd prefer to use Git to track your changes. Do NOT fork or create any **public** repositories as this enables everyone to view your code.

   You will have four files in the `starter` directory:
    - `RPSInterface.java` - The interface for the Rock Paper Scissors game
    - `RPSAbstract.java` - An abstract class that implements some of the methods in RPSInterface
    - `RPS.java` - A concrete class that implements the rest of the RPSInterface
    - `RPSTester.java` - A tester for the code
    
    In the `lib` directory, we have also included the jar files needed to run JUnit tests. 

2. Make sure your environment is set up to compile and run both Java and JUnit tests.  Refer to resources provided on Canvas, and/or come see a tutor if you need help.  (There are instructions below for running JUnit tests from the command line).

4. Compile and run `RPS.java` (`RPSInterface.java` and `RPSAbstract.java` should also compile).  The code should compile and run, but it should only print a message saying that the game is not implemented yet.
    * You can specify different possible moves using command line arguments. If no arguments are provided, the game will use its default set of moves. See examples under "**Example Output for Part 4**".

5. Compile and run `RPSTester.java`.  If you are doing this from the command line and aren’t sure what to type, see below. Make sure you are running these commands from the `starter` directory. You should see most of the tests fail (though a few will pass with the default starter code functionality).

      Running the tester on UNIX based systems (including a mac):

      * Compile: `javac -cp ../libs/junit-4.13.2.jar:../libs/hamcrest-2.2.jar:. RPSTester.java`
      * Execute: `java -cp ../libs/junit-4.13.2.jar:../libs/hamcrest-2.2.jar:. org.junit.runner.JUnitCore RPSTester`

      Running the tester on Windows systems:

      * Compile: `javac -cp ".;..\libs\junit-4.13.2.jar;..\libs\hamcrest-2.2.jar" RPSTester.java`
      * Execute: `java -cp ".;..\libs\junit-4.13.2.jar;..\libs\hamcrest-2.2.jar" org.junit.runner.JUnitCore RPSTester`


## Part 4: Rock-Paper-Scissors with inheritance (90 points)


### Inheritance hierarchy

In this part of the assignment, you will create a computer game to play the game of Rock-Paper-Scissors between the computer and a user.  We have split this into an interface, an abstract class, and a concrete class so you can get comfortable again with inheritance.  

The inheritance hierarchy is shown below.  Please read through the code and make sure you understand how `RPSInterface`, `RPSAbstract`, and `RPS` work together.  Do not change the interface or the inheritance hierarchy.


![](https://i.imgur.com/JM9Yjsa.png)




### Game Play

Your job is to implement the missing methods to complete the implementation of the Rock-Paper-Scissors game.  If you are unfamiliar with this game, you can read about it on Wikipedia[ here](http://en.wikipedia.org/wiki/Rock-paper-scissors) (though we will be implementing a slightly generalized version of the game).

When the user starts your game, it should play the game of Rock Paper Scissors with the user until the user types `q`. Here is an example run. User input is after the `(Type the move or q to quit)`.


```
$ javac RPS.java
$ java RPS
Let's play! What's your move? (Type the move or q to quit)
rock
I chose scissors. You win.
Let's play! What's your move? (Type the move or q to quit)
rock
I chose rock. It's a tie.
Let's play! What's your move? (Type the move or q to quit)
rock
I chose paper. I win.
Let's play! What's your move? (Type the move or q to quit)
q
Thanks for playing!
Our most recent games were: 
Me: paper, You: rock
Me: rock, You: rock
Me: scissors, You: rock
Our overall stats are:
I won: 33.33%
You won: 33.33%
We tied: 33.33%
```


Additional output examples can be viewed at the end of the writeup under "**Example Output for Part 4”.**


### What to Implement

Your task is to implement the following methods in the following files:



#### `RPSAbstract.java`




* `public boolean isValidMove(String move)`: Returns true if the move is valid, and returns false otherwise.  An invalid move is a move that is not in the `possibleMoves` array. 
* `public void playRPS(String playerMove, String cpuMove)`: Play one game of RPS using the moves provided.  This method should:
    * Determine the game outcome (hint: use the `determineWinner` method (see below)).  
    * Print an appropriate message as shown above (e.g. `I chose scissors. You win.`).  Please use the provided static member variables for this purpose.  
    * Record the moves made by the CPU and the Player in the appropriate member variables (`cpuMoves` and `playerMoves`).
    * Increment the number of games played and either the number of ties, CPU wins or player wins, depending on the outcome in the appropriate member variables (`numPlayerWins`, `numCPUWins`, `numTies`, and `numGames`) .



#### `RPS.java`



* `public int determineWinner(String playerMove, String cpuMove)`: Given the two moves, determine the outcome of the game (-1 for invalid input, 0 for tie, 1 for player win, and 2 for cpu win).  But this is not as simple as “rock beats scissors”, “scissors beats paper” and “paper beats rock”!
    * Here is how you should determine the outcome:  All of the possible moves are stored in the array `possibleMoves`.  Each element in the array beats the next element in the array, and the end wraps around to the beginning. All other pairings lead to a tie. This means each move beats one move and loses to one move. For example,  `{ "elephant", "alligator", "hedgehog", "mouse" }` indicates that elephant beats alligator, alligator beats hedgehog, hedgehog beats mouse and mouse beats elephant.  (All other pairings tie).  <span style="text-decoration:underline;">Your code should be able to handle any array of possible moves with at least 3 elements.</span>
    * Make sure you use the provided static member variables from RPSAbstract (`CPU_WIN_OUTCOME, PLAYER_WIN_OUTCOME, TIE_OUTCOME, INVALID_INPUT_OUTCOME`)  in your return statements. 

* `public static void main(String[] args)`: main method that reads user input, generates CPU moves, and plays the game. This method is partially completed and you will fill in the rest.
    * The game should repeat until the player enters `q`.
    * If the player enters `q`, then the game should end and the system should print out up to the last 10 games, in reverse order. If 10 games have not been played, it should print out as many games as has been played. Additionally, use the provided `displayStats()` method to print the win and tie statistics as shown in the example. If you have been updating the member variables as described above, the statistics should display correctly.
    * If there is an invalid move, do not update any instance variables in the game. Do not store the player move or the CPU move in the `playerMoves` and `cpuMoves` arrays. Do not update any of the game stats (`numGames`, `numTies`, `numPlayerWins`, `numCPUWins`).  (Hint: Check if the move is valid before you call `playRPS `and if it is not, do not call `playRPS`).
    * Call `genCPUMove` once each time you prompt the player for a new move. Even if the previous player move is invalid, generate a new move for the CPU.
    * Use the provided static member variables inherited from `RPSAbstract` (`PROMPT_MOVE`, `INVALID_INPUT`) for printing to standard output.


### Additional Implementation Requirements



* You **may not use additional Java packages** from what is given. Please do not include your own import statements. You should be able to do the assignment with what is given.
* You will write your code for the methods described above. Please **do not** alter the provided variable names in the starter code, we will test your code using these variables. Additionally, do not delete variables or change the number of arguments in the methods. Doing so will result in incorrect auto-graded results. Use all provided Strings for consistency.


## Testing

We have provided some JUnit tests in `RPSTester.java`. You are encouraged (but not required this week) to add your own tests to this file. For this week we have given you all of the tests we will grade you on, but in the future that will not be the case!  


## Style

On this assignment, we will give you feedback on style but not deduct points for problems with style. For future assignments, we will be grading the following for style on all files you submit:



* File header
* Class header
* Method header(s)
* Inline comments
* Proper indentation
* Descriptive variable names
* No magic numbers (Exception: Magic numbers can be used for testing.)
* Reasonably short methods (if you have implemented each method according to the specification in this write-up, you’re fine). This is not enforced as strictly.
* Lines shorter than 80 characters
* Javadoc conventions (`@param`, `@return` tags, `/** comments */`, etc.)


A full style guide can be found [here](https://github.com/CaoAssignments/style-guide/blob/main/README.md) and a sample styled file can be found [here](https://github.com/CaoAssignments/style-guide/blob/main/SampleFile.java). If you need any clarifications, feel free to ask on Piazza.


## Example Output for Part 4

Enter `q` immediately:


```
$ java RPS
Let's play! What's your move? (Type the move or q to quit)
q
Thanks for playing!
Our most recent games were: 
Our overall stats are:
I won: NaN%
You won: NaN%
We tied: NaN%
```


More than 10 games:


```
$ java RPS
Let's play! What's your move? (Type the move or q to quit)
rock
I chose scissors. You win.
Let's play! What's your move? (Type the move or q to quit)
rock
I chose rock. It's a tie.
Let's play! What's your move? (Type the move or q to quit)
rock
I chose paper. I win.
Let's play! What's your move? (Type the move or q to quit)
paper
I chose paper. It's a tie.
Let's play! What's your move? (Type the move or q to quit)
paper
I chose paper. It's a tie.
Let's play! What's your move? (Type the move or q to quit)
paper
I chose paper. It's a tie.
Let's play! What's your move? (Type the move or q to quit)
scissors
I chose paper. You win.
Let's play! What's your move? (Type the move or q to quit)
scissors
I chose rock. I win.
Let's play! What's your move? (Type the move or q to quit)
scissors
I chose rock. I win.
Let's play! What's your move? (Type the move or q to quit)
rock
I chose paper. I win.
Let's play! What's your move? (Type the move or q to quit)
paper
I chose rock. You win.
Let's play! What's your move? (Type the move or q to quit)
q
Thanks for playing!
Our most recent games were: 
Me: rock, You: paper
Me: paper, You: rock
Me: rock, You: scissors
Me: rock, You: scissors
Me: paper, You: scissors
Me: paper, You: paper
Me: paper, You: paper
Me: paper, You: paper
Me: paper, You: rock
Me: rock, You: rock
Our overall stats are:
I won: 36.36%1
You won: 27.27%
We tied: 36.36%
```


Invalid input:


```
$ java RPS
Let's play! What's your move? (Type the move or q to quit)
abc
That is not a valid move. Please try again.
Let's play! What's your move? (Type the move or q to quit)
rock
I chose rock. It's a tie.
Let's play! What's your move? (Type the move or q to quit)
q
Thanks for playing!
Our most recent games were: 
Me: rock, You: rock
Our overall stats are:
I won: 0.00%
You won: 0.00%
We tied: 100.00%
```


Using command line args:


```
$ java RPS water fire ice ground electric
Let's play! What's your move? (Type the move or q to quit)
water
I chose fire. You win.
Let's play! What's your move? (Type the move or q to quit)
fire
I chose ice. You win.
Let's play! What's your move? (Type the move or q to quit)
ground
I chose fire. It's a tie.
Let's play! What's your move? (Type the move or q to quit)
electric
I chose ground. I win.
Let's play! What's your move? (Type the move or q to quit)
ice
I chose electric. It's a tie.
Let's play! What's your move? (Type the move or q to quit)
q
Thanks for playing!
Our most recent games were: 
Me: electric, You: ice
Me: ground, You: electric
Me: fire, You: ground
Me: ice, You: fire
Me: fire, You: water
Our overall stats are:
I won: 20.00%
You won: 40.00%
We tied: 40.00%
```



# Submission Instructions

Submit the two Google Forms linked above and the following files to Gradescope:



* `RPSAbstract.java`
* `RPS.java`

**Important**: Even if your code does not pass all the tests, you will still be able to submit your homework to receive partial points for the tests that you passed. **Make sure your code compiles on Gradescope in order to receive partial credit. The name of the files need to match those on the writeup, otherwise no points will be given for the submission.**
