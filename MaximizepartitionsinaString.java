def maxPartitions(s):
    # Step 1: Store last occurrence of each character
    last = {c: i for i, c in enumerate(s)}
    
    count = 0
    maxLast = 0
    
    for i, c in enumerate(s):
        maxLast = max(maxLast, last[c])
        if i == maxLast:
            count += 1
    
    return count

# Test cases
print(maxPartitions("acbbcc"))                  # Output: 2
print(maxPartitions("ababcbacadefegdehijhklij")) # Output: 3
print(maxPartitions("aaa"))                     # Output: 1
