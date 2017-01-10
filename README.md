	# mac-and-cheese

Final Project Proposal
Casino

For our final project, we will be creating a casino where you start off with a set amount of money. With that money you can play games which costs money to play. You can either lose all your money you used or gain some money. When you are left with $0.00, the game is over and you’ve gone bankrupt. This employs superclasses, subclasses, interface, and abstract classes/methods.
<br>(start with connect four and make our way down the list, may not get everything done)
<br>Goal: connect four, wheel of fortune, and blackjack 
Minigames include:
<br>Connect Four
<ul><li>Play against a computer as you strategically place your pieces, attempting to connect four of your pieces in any straight manner.</li>
<li>There will be a board set up with labeled positions. </li>
<li>User chooses where to place piece of choice.</li>
<li>Once 4 in a row is achieve, user wins.</li>
<li>Computer does search for 3 in a row, if not then 2 in a row to try to complete a 4 in a row.</li>
<li>Players play on an int[][] grid, where 0 marks open spaces, 1 marks player’s pieces, 8 marks computer’s pieces. </li>
<li>After every move, a new grid with updated moves is flushed to the terminal. </li></ul><br><br>
Wheel of Fortune
<ul><li>Spin the wheel and receive a random amount of money.</li>
<li>There will be a random phrase on the screen but filled blanks.</li>
<li>The user will guess a letter and if the letter is present in the phrase, the user will get the amount of money for each letter guessed. If not, nothing will happen.</li>
<li>The user has a set amount of guesses.</li>
<li>There will be an option to guess the whole phrase, but it’s win it all or lose it all.</li>
<li>Uses arrays and strings.</li></ul><br><br> 
Blackjack
<ul><li>The player will play against ‘the house’</li>
<li>Limited to one hand at a time, no splitting</li>
<li>Your are dealt your cards, which are displayed in the terminal.  You also see one of the house’s cards.</li>
<li>You have the option to hit or stay, attempting to reach 21 without going over</li>
<li>After you have finished your moves, the computer deal goes</li>
<li>Has a ‘deck’ array, uses that to simulate playing cards. Once a card is dealt, removed that particular card from the array.  The array does not distinguish between suites, as it doesn’t matter in blackjack</li></ul>
