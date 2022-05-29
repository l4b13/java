import ru.ifmo.se.pokemon.*;

public class lab2 {
  public static void main(String[] args) {
    Battle b = new Battle();
    Genesect _genesect = new Genesect("Ivan", 1);
    Makuhita _makuhita = new Makuhita("Petr", 1);
    Hariyama _hariyama = new Hariyama("Egor", 1);
    Lotad _lotad = new Lotad("Dima", 1);
    Lombre _lombre = new Lombre("Senya", 1);
    Ludicolo _ludicolo = new Ludicolo("Stas", 1);
    b.addAlly(_genesect);
    b.addAlly(_hariyama);
    b.addAlly(_lombre);
    b.addFoe(_makuhita);
    b.addFoe(_lotad);
    b.addFoe(_ludicolo);
    b.go();
  }
}