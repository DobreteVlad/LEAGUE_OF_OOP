package util;

public final class Terrain {
    private static Terrain myterrain = null;

    public static void setMyterrain(final Terrain myterrain) {
        Terrain.myterrain = myterrain;
    }

    public static void setTerrains(final char[][] terrains) {
        Terrain.terrains = terrains;
    }

    public static Terrain getMyterrain() {
        return myterrain;
    }

    public static char[][] getTerrains() {
        return terrains;
    }

    private static char[][] terrains;

    private Terrain() {
    }

    public static Terrain getInstance() {
        if (myterrain == null) {
            myterrain = new Terrain();
        }
        return myterrain;
    }

    public static void makemap(final char[][] matrice) {
        terrains = matrice;
    }

    public static char position(final int x, final int y) {
        return terrains[x][y];
    }
}
