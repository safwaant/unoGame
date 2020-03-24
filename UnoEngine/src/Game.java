import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Game {
private Stack<Card> _stackOfCards;
private Player _player1;
private ComputerPlayer _player2;

public Game() {
List<Card> listOfCards = new ArrayList<Card>();
for(int i = 0; i < 10; i++){
listOfCards.add(new Card("Blue", i));
listOfCards.add(new Card("Yellow", i));
listOfCards.add(new Card("Green", i));
listOfCards.add(new Card("Red",i));
}

Collections.shuffle(listOfCards);

_stackOfCards = new Stack<>();

int i = listOfCards.size() - 1;
while (listOfCards.size() > 0) {
_stackOfCards.push(listOfCards.get(i));
listOfCards.remove(i);
i--;
}
_player1 = new Player();
_player2 = new ComputerPlayer();
}

Stack<Card> getStackOfCards() {
return _stackOfCards;
}

Player getPlayer1() {
return _player1;
}

ComputerPlayer getPlayer2() {
return _player2;
}

public void deal() {
for(int i = 0; i < 7; i++) {
Card cardx = _stackOfCards.pop();
_player1.addCard(cardx);

Card cardy = _stackOfCards.pop();
_player2.addCard(cardy);
}
}
public Card initialCard() {
Card topCard = _stackOfCards.pop();
return topCard;
}

public void drawsCards(int num) {
for(int i = 0; i < num; i++) {
Card cardx = _stackOfCards.pop();
_player1.addCard(cardx);
}
}


void player1Plays(Card lastCard)
{

System.out.println("This is your hand: ");

_player1.printHand();

System.out.println("Enter your card (Remember to enter number and "
+ "then card, with space): ");



int topCardNum = lastCard.getCardVal();
String topCardColor = lastCard.getCardColor();

System.out.println("This is the top card: " + topCardNum + " " +topCardColor);
Scanner playerChecker = new Scanner(System.in);

String first = playerChecker.next();
//rename
int first1 = Integer.parseInt(first);

String second = playerChecker.next();
Card newCard = new Card(second, first1);

if (_player1.checkIfIsInHand(newCard) == true) {


if ((first1 == topCardNum
|| second.equals(topCardColor))) {
//System.out.println("works!");
topCardNum = first1;
topCardColor = second;
//Card topCard = new Card(topCardColor, topCardNum);
lastCard = new Card(topCardColor, topCardNum);
_player1.removeCard(newCard);
//_player1.printHand();

if(_player1.getHand().size() != 0) {
computerPlayerPlays(newCard);
}else {
System.out.println("YOU WIN");
return;
}

}else {
System.out.println("Your card was invalid...You drew a card.");
_player1.addCard(_stackOfCards.pop());
}
}

else {
System.out.println("Invalid Card! Not in Deck");
player1Plays(lastCard);
}






}

void computerPlayerPlays(Card lastCard) {
int topCardNum = lastCard.getCardVal();

String topCardColor = lastCard.getCardColor();

Card cardPlayed = _player2.chooseCard(lastCard);
System.out.println("COMPPLAYERHANDBEFORE");
_player2.printHand();
if(cardPlayed.getCardVal() == 1 && cardPlayed.getCardColor().equals(" ")) {
_player2.addCard(_stackOfCards.pop());
System.out.println("COMPPLAYERHANDLATER");
_player2.printHand();
System.out.println("Computer drew a card...Your turn");
player1Plays(lastCard);

}
else {
//tempVal = topCardNum;

//tempColor = topCardColor;

//Card newTop = new Card(topCardColor, topCardNum);

//System.out.println("New top card: " + lastCard);

//System.out.println("origHand: ");
//_player2.printHand();
_player2.removeCard(cardPlayed);

System.out.println("nexthand: ");
_player2.printHand();
if(_player2.getHand().size() != 0) {
System.out.println("Computer played...Your turn.");
player1Plays(cardPlayed);

}else {
System.out.println("COMPUTER WINS");
}
}
}
}


