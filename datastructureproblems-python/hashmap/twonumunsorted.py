from typing import List
        
def pair_sum_unsorted_two_pass(nums: List[int], target: int) -> List[int]:
   #Prepopulate the Map
    num_map={}
    nums_to_index = {}
    for i, num in enumerate(nums):
        nums_to_index[num] = i
    
    for i,num in enumerate(nums):
        complement= target-num
        if complement in nums_to_index and nums_to_index[complement] != i:
            return [i, nums_to_index[complement]]


   

if __name__ == "__main__":
    print(pair_sum_unsorted_two_pass([-1, 3, 4, 2], 3))  # Output: [0, 2]
