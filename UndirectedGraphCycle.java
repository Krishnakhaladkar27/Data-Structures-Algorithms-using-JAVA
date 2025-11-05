from collections import defaultdict

def isCyclic(V, edges):
    # Build adjacency list
    adj = defaultdict(list)
    for u, v in edges:
        adj[u].append(v)
        adj[v].append(u)  # undirected graph

    visited = [False] * V

    def dfs(node, parent):
        visited[node] = True
        for neighbor in adj[node]:
            if not visited[neighbor]:
                if dfs(neighbor, node):
                    return True
            elif neighbor != parent:
                # Found a back edge → cycle
                return True
        return False

    # Check for all components
    for v in range(V):
        if not visited[v]:
            if dfs(v, -1):
                return True

    return False

# Test cases
print(isCyclic(4, [[0, 1], [0, 2], [1, 2], [2, 3]]))  # Output: True
print(isCyclic(4, [[0, 1], [1, 2], [2, 3]]))          # Output: False
