### October 1, 2024

## Features

  Two player local game

## Game Rules

  The Mancala board consists of two rows of six pits each, and a store on each player's right side.
  
  The game starts with 4 pebbles in each pit and no pebbles in the stores.
  
  Players take turns picking up all the pebbles from one of their pits and placing them one at a time into the following pits in a counter-clockwise direction.
  
  If a player passes their own store they place a pebble into it. If they pass their opponent's store, they skip it.
  
  If a player places the last pebble in their own store, they get another turn.
  
  If a player lands in an empty pit on their side of the board, they capture the pebbles from the opposite pit.
  
  The game ends when one player has no more pebbles in their pits. The other player collects all the remaining pebbles in their pits.
  
  The player with the most pebbles in their store at the end of the game wins.

## Classes
  
  Pit- to manage the pebbles in a Pit
  
  Store- to manage the pebbles in a Store
  
  Player- to manage a set of Pits and one Store
  
  MancalaGame– to manage two Players and provide a view of the board while the game is in progress, to determine the winner (if there is one), and to manage the turn each Player has.
  
  Main– to instantiate the Game and begin the Game
