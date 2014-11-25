public class Plane {
    public static Location[][][] genPlane(int length) {
        Location[][][] plane = new Location[length][length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    plane[i][j][k] = new Location(i, j, k);
                }
            }
        }
        return plane;
    }
    public static Location[][][] genPlane(int xLength, int yLength,
        int zLength) {
        Location[][][] plane = new Location[xLength][yLength][zLength];
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                for (int k = 0; k < zLength; k++) {
                    plane[i][j][k] = new Location(i, j, k);
                }
            }
        }
        return plane;
    }
}
