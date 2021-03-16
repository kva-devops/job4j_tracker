package ru.job4j.oop;

public class Story {
    public static void main(String[] args) {
        Ball kolobolo = new Ball();
        Hare kosoi = new Hare();
        Fox rizhaya = new Fox();
        Wolf seriy = new Wolf();
        kosoi.tryEat(kolobolo);
        kolobolo.rushOut(kosoi);
        rizhaya.tryEat(kolobolo);
        kolobolo.rushOut(rizhaya);
        seriy.tryEat(kolobolo);
        kolobolo.rushOut(seriy);
    }
}
