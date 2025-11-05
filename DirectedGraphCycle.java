from collections import defaultdict

def isCyclic(V, edges):
    # Build adjacency list
    adj = defaultdict(list)
    for u, v in edges:
        adj[u].append(v)
    
    visited = [False] * V
    recStack = [False] * V
    
    def dfs(node):
        visited[node] = True
        recStack[node] = True
        
        for neighbor in adj[node]:
            if not visited[neighbor]:
                if dfs(neighbor):
                    return True
            elif recStack[neighbor]:
                return True
        
        recStack[node] = False
        return False
    
    for i in range(V):
        if not visited[i]:
            if dfs(i):
                return True
    return False

# Example usage
V1 = 4
edges1 = [[0, 1], [1, 2], [2, 0], [2, 3]]
print(isCyclic(V1, edges1))  # Output: True

V2 = 4
edges2 = [[0, 1], [0, 2], [1, 2], [2, 3]]
print(isCyclic(V2, edges2))  # Output: False
