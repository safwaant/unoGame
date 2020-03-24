
public class Main {

public static void main(String[] args) {
Game newGame = new Game();
newGame.deal();

while(endGame(newGame) != true) {
newGame.player1Plays(newGame.initialCard());
if(!endGame(newGame)) {
newGame.computerPlayerPlays(newGame.initialCard());
}
else {
break;
}
}

}

static boolean endGame(Game newGame) {
boolean end = false;

if(newGame.getStackOfCards().isEmpty()) {
System.out.println("TIE---You ran out of cards.");
end = true;
}
else {
end = false;
}
return end;
}


}

