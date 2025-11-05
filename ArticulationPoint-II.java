from collections import defaultdict

def articulationPoints(V, edges):
    # Build adjacency list
    adj = defaultdict(list)
    for u, v in edges:
        adj[u].append(v)
        adj[v].append(u)
    
    disc = [-1] * V
    low = [-1] * V
    parent = [-1] * V
    ap = set()
    time = [0]  # Use list to pass by reference
    
    def dfs(u):
        children = 0
        disc[u] = low[u] = time[0]
        time[0] += 1
        
        for v in adj[u]:
            if disc[v] == -1:  # If v is not visited
                parent[v] = u
                children += 1
                dfs(v)
                
                low[u] = min(low[u], low[v])
                
                # Check articulation point conditions
                if parent[u] == -1 and children > 1:
                    ap.add(u)
                if parent[u] != -1 and low[v] >= disc[u]:
                    ap.add(u)
            elif v != parent[u]:
                low[u] = min(low[u], disc[v])
    
    # DFS for all components
    for i in range(V):
        if disc[i] == -1:
            dfs(i)
    
    return sorted(list(ap)) if ap else [-1]

# Example usage
V1 = 5
edges1 = [[0, 1], [1, 4], [4, 3], [4, 2], [2, 3]]
print(articulationPoints(V1, edges1))  # Output: [1, 4]

V2 = 4
edges2 = [[0, 1], [0, 2]]
print(articulationPoints(V2, edges2))  # Output: [0]
