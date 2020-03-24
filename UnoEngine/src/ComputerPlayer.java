import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer {
private List<Card> hand  = new ArrayList<Card>();

List<Card> getHand() {
return hand;
}
void addCard(Card card) {
hand.add(card);
}

void printHand() {
for(int i = 0; i < getHand().size(); i++) {
Card cardx = getHand().get(i);
System.out.print(cardx.getCardVal());
System.out.print(" ");
System.out.println(cardx.getCardColor());
}
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

Card chooseCard (Card topOfDeck) {
Card tempCard;
for (int i = 0; i < hand.size() - 1; i++) {

if (topOfDeck.isMatch((hand.get(i)))) {
tempCard = hand.get(i);
return tempCard;

}
}
return new Card(" ", 1);
}
}



