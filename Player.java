public class Player {
    private String name;
    private PlayerColor color;

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
        return false;
    }
}

// Enum to represent player colors
enum PlayerColor {
    WHITE, BLACK
}
