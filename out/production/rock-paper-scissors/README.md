
# Rock, Paper, Scissors

### A Java OOP Mini-Project
* <a href="#about-the-game">About the Game</a>
* <a href="#how-to-play">How to Play</a>
* <a href="#technologies-used">Technologies Used</a>
* <a href="#diagram">Diagram</a>
* <a href="#user-stories">User Stories</a>
* <a href="#development-process">Development Process</a>
* <a href="#what-i-would-do-different">What I Would Do Different</a>
* <a href="#credits">Credits</a>

## About the Game

Come play a virtual version of rock-paper-scissors!

This fun take on the traditional hand game allows two players to play on the same computer.

Want to play solo? No problem! You can play against a computer too.

## How to Play

#### Installation:

Since this application was built using 100% Java, and Java is a "write once, run anywhere" language, you can play this game if you're using the JVM (Java Virtual Machine). The game is played through the console.

#### Instructions:

1. When you first open the game in the browser, a series of pop-ups will come up.
    * The first pop-up welcomes you to the game (click OK).
    * The subsequent pop-ups allow player 1 and then player 2 to customize their symbols.
    * Symbols can be a single character, a string, or an image URL.
    * If no custom symbol is entered, player 1 is X and player 2 is O by default.

    <br>

2. Player 1 starts (click on any of the nine squares).

3. After player 1 is done, it is automatically player 2's turn (click on any of the remaining squares).

4. Repeat steps 2 and 3 until the game ends. The game ends when a player gets three of their symbols in a row (the winning condition), or until all nine squares are filled (a tie).

5. The score will be automatically updated at the end of each round at the bottom of the page.

6. To start a new game, click the "New Game" button at the top of the page.

7. To clear the scores, click the "Reset Scores" button at the top of the page.

8. To switch between light and dark mode, click the button at the very top right of the page.





## Feature Requirements

Your game must:

- Have a main menu with options to enter `2 players` or `vs. computer`.
- If the user enters `2 players`, they should be able to play rock–paper–scissors against a human competitor.
- If the user enters `vs. computer`, they should be able to play against the computer.
- When the game is over, the winner should be declared.

## Technical Requirements

- Use classes to remove repetitive parts of code, and create an abstract `Player` class to manage the player's state (if they won or lost, how many points they have, what move they made). In addition, interfaces should be used in places where they are necessary.
- Handle invalid user input.
- Handle incorrect capitalization of otherwise valid user input ("rock," "Rock," "RoCk," "ROCK," and more).
- Each class (including a `Player` class) should have methods associated with it and be instantiated as an object (as opposed to a singleton or an interface).
- Use `public`, `private`, and `static` variables, methods, and members within each class appropriately.
- Incorporate exception handling to make sure your game crashes gracefully if it receives bad input.
- Get standard input with Java using a `Scanner`, or use `Processing` to get mouse, keyboard, or other input.
- Use arrays or array lists to store game history (if applicable).
-

## Bonus Ideas

- Write automated JUnit tests for your application.
- Use an Agile project management framework for your game.
- If the user enters `history`, the program should display previous game history (winner's name, game date, and more).
- Use Java packages to modularize code. Place any helper tools in these packages — they could be related input, networking, or graphics.
- Use Maven to install external dependencies your game might require.
- Use [generics](https://docs.oracle.com/javase/tutorial/extra/generics/index.html) on collections such as arrays and array lists to store different data composed of different types.
- Use multithreading to handle concurrent requests (like in multiplayer games).
- Incorporate video, text, data, networking, and sound into your game via `Processing`.

### Necessary Deliverables

Submit a pull request with a Java program that meets the above requirements.

Below, you can see sample output:

```
Welcome to Rock, Paper, Scissors!

MAIN MENU
=====
1. Type 'play' to play.
2. Type 'history' to view your game history.
3. Type 'quit' to stop playing.

play


Type 'rock', 'paper', or 'scissors' to play.
Type 'quit' to go back to the main menu.

rock
Computer picks: scissors
User picks: rock
You win!

Welcome to Rock, Paper, Scissors!

MAIN MENU
=====
1. Type 'play' to play.
2. Type 'history' to view your game history.
3. Type 'quit' to stop playing.

play


Type 'rock', 'paper', or 'scissors' to play.
Type 'quit' to go back to the main menu.

paper
Computer picks: scissors
User picks: paper
You lose!

Welcome to Rock, Paper, Scissors!

MAIN MENU
=====
1. Type 'play' to play.
2. Type 'history' to view your game history.
3. Type 'quit' to stop playing.

history
=== GAME HISTORY ===
WIN: Player picked rock, computer picked scissors
LOSS: Player picked paper, computer picked scissors

Welcome to Rock, Paper, Scissors!

MAIN MENU
=====
1. Type 'play' to play.
2. Type 'history' to view your game history.
3. Type 'quit' to stop playing.

quit
```

---

#### Suggested Ways to Get Started

- Don't hesitate to write throwaway code to solve short-term problems.
- Read the docs for whatever technologies you use. **Most of the time, you can follow a tutorial. However, learning to read documentation is crucial to your success as a developer.**
- Write pseudocode before you write actual code.

---

### Useful Resources

- [Random Number Generator](https://docs.oracle.com/javase/8/docs/api/java/util/Random.html)
- [Rules and History of Rock–Paper–Scissors](https://en.wikipedia.org/wiki/Rock-paper-scissors)

---





2. Create project tracker
    - Use an Agile project management framework for your game.
    - project management
    - kanban board
    - agile methodology
- - See tic-tac-toe readme for reference
- See project readme for reference
- See previous README requirements (challenges, proud of, etc)
- MVP Levels
- Toolbox:
    - Java Language
    - IntelliJ IDEA IDE
        - Build System: IntelliJ
        - JDK: corretto-17, Amazon Correto version 17.0.6
    - Google Chrome browser
- Resources used:
    - [https://git.generalassemb.ly/java-interapt-3-13-2023/java-oop-mini-projec](https://git.generalassemb.ly/java-interapt-3-13-2023/java-oop-mini-project)
    - [https://docs.oracle.com/javase/8/docs/api/java/util/Random.html](https://docs.oracle.com/javase/8/docs/api/java/util/Random.html)
    - [https://en.wikipedia.org/wiki/Rock-paper-scissors](https://en.wikipedia.org/wiki/Rock-paper-scissors)
    - [https://git.generalassemb.ly/java-interapt-3-13-2023/java-superhero-lab](https://git.generalassemb.ly/java-interapt-3-13-2023/java-superhero-lab)
    - [https://www.javatpoint.com/java-bufferedreader-class](https://www.javatpoint.com/java-bufferedreader-class)
    - [https://www.javatpoint.com/java-bufferedwriter-class](https://www.javatpoint.com/java-bufferedwriter-class)
    - [https://www.javatpoint.com/Scanner-class](https://www.javatpoint.com/Scanner-class)
    - [https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html](https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html)
- Screenshots of the game and my flow diagrams

- Acknowledgements
    - Kevin, Jay, Obinna, Tobe (hiding input), Dominique (badges https://github.com/alexandresanlim/Badges4-README.md-Profile)
    - “You can’t spell Kim without persistence” - Obinna
- refactored code
    - all methods were in game class
    - moved repetitive methods to other classes/interfaces
2. Submit project:
    - Submit a pull request with a Java program that meets the above requirements.
    - Link to project repository (readme, java files)

    
---

---
## Technologies Used

* **[wireframe.cc](https://wireframe.cc/)**: Used to create wireframe.
* **Command Line**: Used to create and navigate files and folders.
* **Git**: Used for version control on local computer and pushing changes to remote repository.
* **GitHub**: Used to host the remote repository and hosting the live website.
* **Visual Studio Code**: Used as the code editor for manipulating JavaScript, HTML, CSS files, and the README.
* **Google Chrome**: The **browser** was used for running the live environment and accessing materials on the internet. The **Developer Tools** features were used for debugging.

<br>

### Credits

* Code from [Bobby Hadz](https://bobbyhadz.com/blog/javascript-check-if-url-is-image)

  I used this code snippet to detect if a player's symbol input is an image URL. The function takes a URL and returns true if the string input ends with an image file extension.

        function isImage(url) {
        return /\.(jpg|jpeg|png|webp|avif|gif|svg)$/.test(url);
        }
* Favicon tic-tac-toe image from here: https://stock.adobe.com/search/images?k=3x3
* Light theme background image from here: https://www.pinterest.com/pin/580894051940117418/
* Audio from [Zapsplat](https://www.zapsplat.com/)
    * [Color theme button sound]( https://www.zapsplat.com/music/caravan-bathroom-sink-light-switch-press-on-or-off/)
    * [New Game button sound]( https://www.zapsplat.com/music/clean-digital-game-tone-level-up-win-or-finish/)
    * [Reset Scores button sound]( https://www.zapsplat.com/music/several-pieces-of-a4-paper-dump-into-small-plastic-trash-can-2/)
    * [Player 1 click sound]( https://www.zapsplat.com/music/game-sound-short-single-click-pop-generic-use-4/)
    * [Player 2 click sound]( https://www.zapsplat.com/music/game-sound-short-single-click-pop-generic-use-2/)
    * [Winner announcement sound](https://www.zapsplat.com/music/alert-prompt-win-positive-tone-000/)

<br> 

Thank you to Dhrubo Chowdhury and Leonardo Rodriguez for their guidance during this game's development and deployment!

---
## Diagram

Link to wireframe: https://wireframe.cc/3rTSVs

![wireframe](wireframe.png)

---
## User Stories

[From this list of project requirements:](https://git.generalassemb.ly/java-interapt-3-13-2023/Project-1)

* As a user, I should be able to start a new tic tac toe game
* As a user, I should be able to click on a square to add X first and then O, and so on
* As a user, I should be shown a message after each turn for if I win, lose, tie or who's turn it is next
* As a user, I should not be able to click the same square twice
* As a user, I should be shown a message when I win, lose or tie
* As a user, I should not be able to continue playing once I win, lose, or tie
* As a user, I should be able to play the game again without refreshing the page

---
## Development Process

[From this list of project requirements:](https://git.generalassemb.ly/java-interapt-3-13-2023/Project-1)

### MVP
* Render a game board in the browser
* Switch turns between X and O (or whichever markers the player selects)
* Visually display which side won if a player gets three in a row, or show a draw if neither player wins
* Include separate HTML / CSS / JavaScript files
* Stick with KISS (Keep It Simple Stupid) and DRY (Don't Repeat Yourself) principles
* Use JavaScript for DOM manipulation
* Deploy the game online, where the rest of the world can access it
* Use GitHub Pages for deploying your project
* Use semantic markup for HTML and CSS (adhere to best practices)
* Have well-formatted, and well-commented code

### Additional Features

* Keep track of multiple game rounds with a win, lose and tie counter
* Allow players to customize their tokens (X, O, name, or picture)
* Involve Audio in the game
* Make the site fully responsive so that it is playable from a mobile phone
* Get inventive with the styling e.g. use hover effects

### Favorite Feature

Light Mode               | Dark Mode
:-----------------------:|:----------------------:
![light mode](light.png) | ![dark mode](dark.png)

I absolutely love dark mode, so of course I went ahead and added it to my product! This feature was a very simple JS class toggle that allowed additional CSS styling to be added to the body of the HTML. Despite its simplicity, I was very happy to gain understanding as to how my favorite application feature works.

### Product Design

* My layout consist of nested CSS grids - one for the body of the page, and nested within it is one for the 3x3 game board.

* Using the browser's built-in prompt function, the players can customize their symbol tokens.

* Win Condition: I used destructuring assignment to create an array with all possible winning tile combinations' positions. The function looks at all of the winning combination positions and see if there is a matching symbol at each index of all the tiles.

* Tie Condition: I created an array that updated with each player's move. Once the array was filled to nine moves, if there are no unfilled tiles, then the game is a tie.

* The New Game and Reset Scores button resets the game conditions to their initial state. This way, the player does not have to reload the webpage to clear the tracked game information.

---
## What I Would Do Different

I would use form submission to update the players' symbol tokens instead of prompts.

* I did not realize that the prompts go away if you click elsewhere on the browser. This creates a clunky user experience if the player wanted to exit the game tab to grab an image url from the same browser window.
* By using prompts, I had to interpolate the image URL given so that I can update each game tile's innerHTML. This interferes with the hover effect of each tile when the symbol is an image. Currently, the hover effect only works with images if you mouseout of the tile and then come back into it. B

By using a form submission, or presenting players with a set list of images to choose form, I hope to bypass these issues in future versions of the game.