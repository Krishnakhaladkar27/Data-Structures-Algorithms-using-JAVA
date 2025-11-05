from collections import deque, defaultdict

def topologicalSort(V, edges):
    # Step 1: Build adjacency list and compute in-degrees
    adj = defaultdict(list)
    in_degree = [0] * V
    
    for u, v in edges:
        adj[u].append(v)
        in_degree[v] += 1
    
    # Step 2: Initialize queue with all vertices having in-degree 0
    queue = deque([i for i in range(V) if in_degree[i] == 0])
    
    topo_order = []
    
    # Step 3: BFS
    while queue:
        node = queue.popleft()
        topo_order.append(node)
        
        for neighbor in adj[node]:
            in_degree[neighbor] -= 1
            if in_degree[neighbor] == 0:
                queue.append(neighbor)
    
    # If topological ordering contains all vertices, return it
    if len(topo_order) == V:
        return topo_order
    else:
        return []  # Graph is not a DAG (shouldn't happen as input is DAG)
    
# Example usage
V1, E1 = 4, 3
edges1 = [[3, 0], [1, 0], [2, 0]]
print(topologicalSort(V1, edges1))  # Output: any valid topo sort, e.g., [3,1,2,0]

V2, E2 = 6, 6
edges2 = [[1, 3], [2, 3], [4, 1], [4, 0], [5, 0], [5, 2]]
print(topologicalSort(V2, edges2))  # Output: valid topo sort, e.g., [4,5,2,1,0,3]
