from collections import deque

def bfsOfGraph(V, adj):
    visited = [False] * V
    result = []
    queue = deque([0])
    visited[0] = True
    
    while queue:
        node = queue.popleft()
        result.append(node)
        for neighbor in adj[node]:
            if not visited[neighbor]:
                visited[neighbor] = True
                queue.append(neighbor)
    
    return result

# Test cases
print(bfsOfGraph(5, [[2, 3, 1], [0], [0, 4], [0], [2]]))  # Output: [0, 2, 3, 1, 4]
print(bfsOfGraph(5, [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]))  # Output: [0, 1, 2, 3, 4]
