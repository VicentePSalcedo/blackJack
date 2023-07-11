package src;

public class BlackJack {
    public static void main(String[] args) {
        System.out.println("Welcome to BlackJack.");
        Game game = new Game();
        while (!game.IsComplete()) {
            game.run();
        }
        System.out.println("See ya next time!");
    }
}