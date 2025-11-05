import heapq

def minCostConnectHouses(houses):
    n = len(houses)
    
    # Array to store min distance to MST
    minDist = [float('inf')] * n
    minDist[0] = 0  # Start from house 0
    visited = [False] * n
    heap = [(0, 0)]  # (cost, house_index)
    totalCost = 0
    
    while heap:
        cost, u = heapq.heappop(heap)
        if visited[u]:
            continue
        visited[u] = True
        totalCost += cost
        
        for v in range(n):
            if not visited[v]:
                # Manhattan distance
                dist = abs(houses[u][0] - houses[v][0]) + abs(houses[u][1] - houses[v][1])
                if dist < minDist[v]:
                    minDist[v] = dist
                    heapq.heappush(heap, (dist, v))
                    
    return totalCost

# Example Usage
houses1 = [[0, 7], [0, 9], [20, 7], [30, 7], [40, 70]]
print(minCostConnectHouses(houses1))  # Output: 105

houses2 = [[0, 0], [1, 1], [1, 3], [3, 0]]
print(minCostConnectHouses(houses2))  # Output: 7
