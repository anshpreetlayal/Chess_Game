public class Player {
    private String name;
    private PlayerColor color;
    private Game game;

    public Player(String name, PlayerColor color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public PlayerColor getColor() {
        return color;
    }

    public boolean isWhite() {
        return color == PlayerColor.WHITE;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}

// Enum to represent player colors
enum PlayerColor {
    WHITE, BLACK
}
