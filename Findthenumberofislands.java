def numIslands(grid):
    if not grid:
        return 0
    
    n, m = len(grid), len(grid[0])
    visited = [[False for _ in range(m)] for _ in range(n)]
    
    # Directions: 8 directions (horizontal, vertical, diagonal)
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1),
                  (-1, -1), (-1, 1), (1, -1), (1, 1)]
    
    def dfs(x, y):
        visited[x][y] = True
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m:
                if grid[nx][ny] == 'L' and not visited[nx][ny]:
                    dfs(nx, ny)
    
    islands = 0
    for i in range(n):
        for j in range(m):
            if grid[i][j] == 'L' and not visited[i][j]:
                islands += 1
                dfs(i, j)
    
    return islands

# Test cases
grid1 = [['L', 'L', 'W', 'W', 'W'], 
         ['W', 'L', 'W', 'W', 'L'], 
         ['L', 'W', 'W', 'L', 'L'], 
         ['W', 'W', 'W', 'W', 'W'], 
         ['L', 'W', 'L', 'L', 'W']]
print(numIslands(grid1))  # Output: 4

grid2 = [['W', 'L', 'L', 'L', 'W', 'W', 'W'], 
         ['W', 'W', 'L', 'L', 'W', 'L', 'W']]
print(numIslands(grid2))  # Output: 2
