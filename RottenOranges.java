from collections import deque

def orangesRotting(mat):
    rows, cols = len(mat), len(mat[0])
    queue = deque()
    fresh_count = 0
    
    # Initialize queue with rotten oranges
    for r in range(rows):
        for c in range(cols):
            if mat[r][c] == 2:
                queue.append((r, c, 0))  # (row, col, time)
            elif mat[r][c] == 1:
                fresh_count += 1
    
    # Directions: up, down, left, right
    directions = [(-1,0), (1,0), (0,-1), (0,1)]
    time_taken = 0
    
    while queue:
        r, c, time = queue.popleft()
        time_taken = max(time_taken, time)
        for dr, dc in directions:
            nr, nc = r + dr, c + dc
            if 0 <= nr < rows and 0 <= nc < cols and mat[nr][nc] == 1:
                mat[nr][nc] = 2
                fresh_count -= 1
                queue.append((nr, nc, time + 1))
    
    return time_taken if fresh_count == 0 else -1

# Test cases
print(orangesRotting([[2, 1, 0, 2, 1], [1, 0, 1, 2, 1], [1, 0, 0, 2, 1]]))  # Output: 2
print(orangesRotting([[2, 1, 0, 2, 1], [0, 0, 1, 2, 1], [1, 0, 0, 2, 1]]))  # Output: -1
