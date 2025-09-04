from typing import List

def pair_sum_unsorted(nums: List[int], target: int) -> List[int]:
    hashmap = {}
    for i, x in enumerate(nums):
        if target - x in hashmap:
            return [hashmap[target - x], i]
        hashmap[x] = i
    return []

if __name__ == "__main__":
    print(pair_sum_unsorted([3, 2, 4, 3], 6))  # Output: [1, 2]
