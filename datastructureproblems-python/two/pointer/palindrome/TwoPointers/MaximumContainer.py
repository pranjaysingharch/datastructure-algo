def maxArea(heights):
   max_area = 0
   left=0
   right=len(heights)-1
   while(left<right):
      width=right-left
      min_height=min(heights[left],heights[right])
      max_area=max(min_height*width,max_area)
      if heights[left]<heights[right]:
        left+=1
      else:
        right-=1
   return max_area

if __name__ == "__main__":
   print("Hello World")
   heights = [8, 7, 8, 3, 7, 6]
   print(maxArea(heights))
