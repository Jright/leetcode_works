package No1001_1050;

public class No1041_RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int x = 0;
        int y = 0;

        int idx = 0;

        for (char index : instructions.toCharArray()) {
            if (index == 'L') {
                idx = (idx + 3) % 4;
            } else if (index == 'R') {
                idx = (idx + 1) % 4;
            } else {
                x += directions[idx][0];
                y += directions[idx][1];
            }
        }

        return (x == 0 && y == 0) || (idx != 0);
    }
}
