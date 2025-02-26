package angels;

public class AngelFactory {
    private static AngelFactory instance = null;

    public static AngelFactory getInstance() {
        if (instance == null) {
            instance = new AngelFactory();
        }
        return instance;
    }

    /**
     * @param type
     * @param x
     * @param y
     * @return
     */
    public Angel createAngel(final String type, final int x, final int y) {
        switch (type) {
            case "LifeGiver":
                return new LifeGiver(x, y);
            case "LevelUpAngel":
                return new LevelUpAngel(x, y);
            case "DamageAngel":
                return new DamageAngel(x, y);
            case "DarkAngel":
                return new DarkAngel(x, y);
            case "Dracula":
                return new Dracula(x, y);
            case "GoodBoy":
                return new GoodBoy(x, y);
            case "SmallAngel":
                return new SmallAngel(x, y);
            case "XPAngel":
                return new XPAngel(x, y);
            case "TheDoomer":
                return new TheDoomer(x, y);
            case "Spawner":
                return new Spawner(x, y);
            default:
                return null;
        }
    }
}
