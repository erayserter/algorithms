class Solution {
    class Location {
        int x;
        int y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        int totalOrange = 0;
        Set<Location> rotten = new HashSet<>();
        int minutes = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) totalOrange++;
                if (grid[i][j] == 2) rotten.add(new Location(i, j));
            }
        }

        while (rotten.size() < totalOrange) {
            System.out.println("rottensize: " + rotten.size() + " total orange: " + totalOrange);
            int[][] willBeRotten = new int[grid.length][grid[0].length];

            for (Location loc: rotten) {
                if (loc.x < grid.length - 1 && grid[loc.x + 1][loc.y] == 1) {
                    willBeRotten[loc.x + 1][loc.y] = 1;
                }
                if (loc.y < grid[0].length - 1 && grid[loc.x][loc.y + 1] == 1) {
                    willBeRotten[loc.x][loc.y + 1] = 1;
                }
                if (loc.x > 0 && grid[loc.x - 1][loc.y] == 1) {
                    willBeRotten[loc.x - 1][loc.y] = 1;
                }
                if (loc.y > 0 && grid[loc.x][loc.y - 1] == 1) {
                    willBeRotten[loc.x][loc.y - 1] = 1;
                }
            }

            int lastSize = rotten.size();

            for (int i = 0; i < willBeRotten.length; i++) {
                for (int j = 0; j < willBeRotten[i].length; j++) {
                    if (willBeRotten[i][j] == 1) {
                        grid[i][j] = 2;
                        rotten.add(new Location(i, j));
                    }
                }
            }

            if (lastSize == rotten.size()) return -1;

            minutes++;
        }

        return minutes;
    }
}