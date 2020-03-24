import java.util.Scanner;

public class Card {
private  String _cardColor;
private int _cardVal;

String getCardColor() {
return _cardColor;
}
int getCardVal() {
return _cardVal;
}

public Card() {}

public Card(String cardColor, int cardVal) {
this._cardColor = cardColor;
this._cardVal = cardVal;
}

public String toString() {
return String.valueOf(this._cardVal) + " " + this._cardColor;
}

public boolean isMatch(Card card) {
if (card.getCardColor().equals(this._cardColor) || card.getCardVal() == this._cardVal) {
return true;
}
else {
return false;
}
}

//void toCard(Scanner scanner) {
//card = scanner.nextLine();

//}
}

