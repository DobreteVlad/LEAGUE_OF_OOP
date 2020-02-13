package players;

public final class PlayerFactory {
    private static PlayerFactory instance = null;

    private PlayerFactory() {

    }

    public static PlayerFactory getInstance() {
        if (instance == null) {
            instance = new PlayerFactory();
        }
        return instance;
    }

    public Player createPlayer(final String type, final int x, final int y) {
        switch (type) {
            case "P":
                return new Pyromancer(x, y);
            case "K":
                return new Knight(x, y);
            case "W":
                return new Wizard(x, y);
            case "R":
                return new Rogue(x, y);
            default:
                return null;
        }
    }
}
