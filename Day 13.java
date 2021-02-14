/*
Shortest Path in Binary Matrix
In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:

Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
C_1 is at location (0, 0) (ie. has value grid[0][0])
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.

 

Example 1:

Input: [[0,1],[1,0]]


Output: 2

Example 2:

Input: [[0,0,0],[1,1,0],[1,1,0]]


Output: 4

 

Note:

1 <= grid.length == grid[0].length <= 100
grid[r][c] is 0 or 1
*/
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if(grid[0][0] == 1 || grid[row - 1][col - 1] == 1) return -1;
        if(row == 1 && col == 1 && grid[0][0] == 0)return 1;
        
        int directions[][] = new int[][]{{1,0},{0,1},{-1,0},{0,-1},{-1,-1},{-1,1},{1,1},{1,-1}};
        Queue <int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int steps = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int j = 0; j < size; j++){
                int arr[] = queue.poll();
                for(int i = 0; i < 8; i++){
                    int newX = arr[0] + directions[i][0];
                    int newY = arr[1] + directions[i][1];
                    if((newX < 0) ||(newY < 0) || (newX >= col) ||(newY >= row) || grid[newX][newY] == 1)   continue;
                    if((newX == col - 1) && (newY == row - 1)) return steps + 1;
                    grid[newX][newY] = 1;
                    queue.add(new int[]{newX,newY});
                }               
            }
            steps++;
        }
    
    return -1;
    }
}