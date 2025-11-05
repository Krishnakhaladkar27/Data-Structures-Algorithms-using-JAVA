def dfsOfGraph(V, adj):
    visited = [False] * V
    result = []

    def dfs(node):
        visited[node] = True
        result.append(node)
        for neighbor in adj[node]:
            if not visited[neighbor]:
                dfs(neighbor)
    
    dfs(0)  # start DFS from vertex 0
    return result

# Test cases
print(dfsOfGraph(5, [[2, 3, 1], [0], [0, 4], [0], [2]]))  # Output: [0, 2, 4, 3, 1]
print(dfsOfGraph(5, [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]))  # Output: [0, 1, 2, 3, 4]
