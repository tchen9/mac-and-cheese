# mac-and-cheese

Final Project Proposal
Casino

\t	For our final project, we will be creating a casino where you start off with a set amount of money. With that money you can play games which costs money to play. You can either lose all your money you used or gain some money. When you are left with $0.00, the game is over and you’ve gone bankrupt. This employs superclasses, subclasses, interface, and abstract classes/methods.
\n(start with connect four and make our way down the list, may not get everything done)
\nGoal: connect four, wheel of fortune, and blackjack 
\nMinigames include:
\nConnect Four
\nPlay against a computer as you strategically place your pieces, attempting to connect four of your pieces in any straight manner.
\n\tThere will be a board set up with labeled positions. 
\n\tUser chooses where to place piece of choice.
\n\tOnce 4 in a row is achieve, user wins.
\n\tComputer does search for 3 in a row, if not then 2 in a row to try to complete a 4 in a row.
\n\tPlayers play on an int[][] grid, where 0 marks open spaces, 1 marks player’s pieces, 8 marks computer’s pieces
\n\tAfter every move, a new grid with updated moves is flushed to the terminal
\n\nWheel of Fortune
\n\tSpin the wheel and receive a random amount of money.
\n\tThere will be a random phrase on the screen but filled blanks.
\n\tThe user will guess a letter and if the letter is present in the phrase, the user will get the amount of money for each letter guessed. If not, nothing will happen.
\n\tThe user has a set amount of guesses.
\n\tThere will be an option to guess the whole phrase, but it’s win it all or lose it all.
\n\tUses arrays and strings. 
\n\nBlackjack
\n\tThe player will play against ‘the house’
\n\tLimited to one hand at a time, no splitting
\n\tYour are dealt your cards, which are displayed in the terminal.  You also see one of the house’s cards. 
\n\tYou have the option to hit or stay, attempting to reach 21 without going over
\n\tAfter you have finished your moves, the computer deal goes
\n\tHas a ‘deck’ array, uses that to simulate playing cards. Once a card is dealt, removed that particular card from the array.  The array does not distinguish between suites, as it doesn’t matter in blackjack
