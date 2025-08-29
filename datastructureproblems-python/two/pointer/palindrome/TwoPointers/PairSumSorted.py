def pair_sum_sorted(arr, target):
    left=0;
    right=len(arr)-1
    pair=[]
    while(left<right):
        current_sum=arr[left]+arr[right]
        if(current_sum==target):
            pair.append([left,right])
            left+=1
            right-=1
        elif(current_sum<target):
            left+=1
        else:
            right-=1
    return pair
if __name__=="__main__":
    arr = [-5, -2, 3, 4, 6]
    print(type(arr))
    target = 1
    result = pair_sum_sorted(arr, target)
    if result:
        print(f"Pair found at indices: {result}")
    else:
        print("No pair found.")
