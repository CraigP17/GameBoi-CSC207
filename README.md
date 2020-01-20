# GameBoi

  GameBoi is the final group project for CSC207 Software Design course. The assignment was to create a game with multiple levels, a scoring system, and allow users to sign in and resume previous games. It requires a minimum of 3 levels, with each level being structurally different, and user statistics that need to be tracked and allow for user customizations.

  The goal of the project was the implement Clean Architecture design principles and Design Patterns, with proper Packaging of files. The course taught object-oriented programming using Java and version control with Git.

  The project was split into two phases. Phase 1 was to have a base version of the game with basic levels to have a base structure finished with file saving. Phase 2 is the final version of the game, with all levels fully implemented with a working scoreboard, with design principles and patterns enforced.

#### GameBoi consists of:
  * **Level 1:** Math Game
  * **Level 2:** Flashing Colours Game
  * **Level 3:** Rock Paper Scissors Game
  * **Bonus Rounds:** Bonus Multiplier Spinner

  See list at bottom of README.md for more information on each game level.

## Overview of Game

The game starts at a login screen that shows 3 users that are in the file. If no users have been created, you will need to create a new user. where you will be taken to a new screen that lets you pick your 3 customizations for your user. The customizations are icon, background colour and number of lives.

After the customizations are complete you will begin playing the Math Game, then Flash Colours, and lastly the user plays the Rock Paper Scissors game, with a Bonus Multiplier game after each. Finally, the player visits the final screen, which is a leader board screen that displays the top three scorers that have played Gameboi. The leaderboard can also be sorted by other player stats such as current score, high score, multiplier, lives.

## Prerequisites

* Android Studio
* Java SE 8

## Built With

* [Android Studio](https://developer.android.com/studio) - IDE
* [Java Development Kit 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java SE Development Kit
* [Git](https://git-scm.com/downloads) - Used for Version Control
* [Pie API 28](https://www.android.com/versions/pie-9-0/) - Used Android 9 Pie for Virtual Device

## Authors

* **Craig Pinto** - [Github](https://github.com/CraigP17)
* **Jacob Rajah** - [Github](https://github.com/JacobRajah)
* **Sarrah Merchant** - [Github](https://github.com/sarrahmerchant10)
* **Anjali Parikh** - [Github](https://github.com/Anjali5122)
* **Sam Childerhose**

# Game Specifics

### Bonus Spinner (Bonus Game)
  Creator: **Craig Pinto**

  The player reaches this round after every level where they are
  given the opportunity to increase their multiplier. The multiplier
  can be increased by 1x, 2x, 3x., with different probabilities of landing on each section.

  The player would press the SPIN button to have the wheel rotate.
  Whichever section of the Bonus Wheel that it lands on, denoted by
  the arrow pointer at the top, is then multiplied by the User's
  current multiplier to get their new multiplier.
  The spinnerwheel.png and pointer.png were made from scratch using
  Figma to draw the images.

### Math Game (Level 1)
 Creator: **Sam Childerhose**

 This level asks the player a series of math questions. If the
 player answers 3 incorrectly they lose a life and the game ends.
 Every question they answer correct, adds 1 point to their score.
 There are a total of 10 possible rounds. After the player completes
 the Math game with at least 1 life remaining, they can move on to
 next level.

### Flash Colours Game (Level 2)
 Creators: **Craig Pinto** and **Jacob Rajah**

 This levels starts once the player presses the 'start' button, at
 which point a button will flash a series of colours at random. The
 player must remember the pattern and click the colours
 corresponding to the pattern they saw. If they correctly match the
 pattern, they will earn a point. If they lose two rounds, they lose
 this level. There are a total of 4 rounds before the player can
 continue the game.

 There is a hidden feature of this level where if the player enters
 a particular combination based on their chosen difficulty, their multiplier is increased by a factor of 2.

 **Normal:** Blue, Red, Green Yellow

 **Hard:** Blue, White, Red, Green, Yellow, Black

### Rock Paper Scissors Game (Level 3)
  Creators: **Sarrah Merchant** and **Anjali Parikh**

  This level lets the player play a game of rock paper scissors
  against the computer. If the player loses 2 rounds first then they
  lose the rock paper scissors game. If the player wins 3 rounds
  before losing two, then they win the rock paper scissors game. In
  the hard mode of this game, there are two more options to play
  which increases the difficulty of winning.

  **Hidden Feature:**
  In the easy round the player needs to select Scissors and the
  computer needs to randomly choose Rock. This combo "Scissors",
  "Rock" increases the player's multiplier.

## Acknowledgments

**Icon Images Source:**
* [Boy](https://images.app.goo.gl/bBxsHPLu6xqSTvQG6)
* [Panda](https://www.cleanpng.com/png-po-master-shifu-tigress-giant-panda-kung-fu-panda-674481/)
* [Snake](https://www.cleanpng.com/png-cartoon-clip-art-red-snake-1278542/download-png.html)
* [Rock, Paper, Scissors](https://www.amazon.com/Onipse-Dev-Rock-Paper-Scissors/dp/B07B3KJ966)
* [Rock, Paper, Scissors, Lizard, Spock](https://www.google.com/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwja1ta3xfjmAhUxB50JHeN4COoQjRx6BAgBEAQ&url=https%3A%2F%2Fgithub.com%2Frodosaenz%2Fjavascript-rock-paper-scissors-lizard-spock&psig=AOvVaw2tQ-YsXJa8BFGVW88OITrs&ust=1578728857522318)

**Code Source Help**\
The links below refer to pages where code was found. These sources were used to help implement flash
colours, as well as in FileManager where a file needs to be written to.
* [Using ValueAnimator](https://stackoverflow.com/questions/15582434/using-a-valueanimator-to-make-a-textview-blink-different-colors)
* [Grabbing Resources by ID](https://android.okhelp.cz/get-resource-id-by-resources-string-name-android-example/)
* [Reading and Writing to Files](https://stackoverflow.com/questions/14376807/how-to-read-write-string-from-a-file-in-android)
* [Spinning Wheel](https://medium.com/@ssaurel/develop-a-roulette-game-for-android-316e349f91a)
