class Solution {
    public int orangesRotting(int[][] grid) {

        if( grid == null || grid.length == 0 ){
            return 0;
        }

        Queue<int []> queue = new LinkedList<>();
        int fresh = 0;

        for ( int row = 0 ; row < grid.length; row++ ) {
            for ( int col = 0; col < grid[0].length; col++){
                if ( grid[row][col] == 2 ){
                    queue.add(new int[]{row, col});
                } else if ( grid[row][col] == 1 ){
                    fresh++;
                }
            }
        }

        if (fresh == 0){
            return 0;
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int minutesPassed = -1;

        while(!queue.isEmpty()){
            int orangeInCurrentLevel = queue.size();
            minutesPassed++;

            for ( int i = 0; i < orangeInCurrentLevel; i++ ){
                int[] position = queue.remove();
                int row = position[0]; int col = position[1];

                for (int[] direction: directions){
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if ( newCol < 0 || newRow < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] != 1){
                        continue;
                    }

                    grid[newRow][newCol] = 2;
                    fresh--;

                    queue.add(new int[]{newRow, newCol});

                }

            }

        }

        if ( fresh == 0 ){
            return minutesPassed;
        } else {
            return -1;
        }
        
    }
}