
def shift_zeros_to_end(nums):
    left=0
    for right in range(len(nums)):
        if nums[right] != 0:
            nums[left], nums[right] = nums[right], nums[left]
            left += 1

if __name__ == "__main__":
    nums = [0, 1, 0, 3, 2]
    shift_zeros_to_end(nums)
    
    print(nums)  # Output: [1, 3, 2, 0, 0]
