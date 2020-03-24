import java.util.*;

public class Player {
private List<Card> hand  = new ArrayList<Card>();

List<Card> getHand() {
return hand;
}

void addCard(Card card) {
hand.add(card);
}

public boolean checkIfIsInHand(Card playedCard) {
boolean bool = false;
for (Card card : hand) {
if (playedCard.getCardVal() == card.getCardVal() 
&& playedCard.getCardColor().equals(card.getCardColor())) {
bool = true;
break;
}
else {
bool = false;
}
}
return bool;
}
void removeCard(Card card) {
Card toBeRemoved = null;
for (Card c : hand) {
if (c.getCardVal() == card.getCardVal() && c.getCardColor().equals(card.getCardColor())) {
toBeRemoved = c;
}
}
if (toBeRemoved != null) {
hand.remove(toBeRemoved);
}
}

void printHand() {
for(int i = 0; i < getHand().size(); i++) {
Card cardx = getHand().get(i);
System.out.print(cardx.getCardVal());
System.out.print(" ");
System.out.println(cardx.getCardColor());
}
}

/* boolean checkHand(String cardString, Card topCard) {
for(int i = 0; i < getHand().size(); i++) {
String compareValue = Integer.toString(card.getCardVal()) + card.getCardColor().toString();
if (cardString == topCard.toString()) {
return true;
} else {
return false;
}
}
return false; 

}*/
Card chooseCard (Card topOfDeck) {

for (int i = 0; i < hand.size() - 1; i++) {

if (topOfDeck.isMatch(hand.get(i))) {
}else {
topOfDeck = new Card(" ", 1);
return topOfDeck;
}
}
return null;

}

}

