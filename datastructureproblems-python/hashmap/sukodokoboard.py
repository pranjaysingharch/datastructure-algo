def isValidSudoku(board):
    rows = [set() for _ in range(9)]
    cols = [set() for _ in range(9)]
    boxes = [set() for _ in range(9)]  # 3x3 boxes indexed 0-8
    
    for r in range(9):
        for c in range(9):
            val = board[r][c]
            if val == ".":
                continue
            
            # Box index formula
            box_idx = (r // 3) * 3 + (c // 3)
            
            # Check duplicates
            if (val in rows[r]) or (val in cols[c]) or (val in boxes[box_idx]):
                return False
            
            # Add to sets
            rows[r].add(val)
            cols[c].add(val)
            boxes[box_idx].add(val)
    
    return True

# Sample Sudoku board for testing
sample_board = [
    [5, 3, ".", ".", 7, ".", ".", ".", "."],
    [6, ".", ".", 1, 9, 5, ".", ".", "."],
    [".", 9, 8, ".", ".", ".", ".", 6, "."],
    [8, ".", ".", ".", 6, ".", ".", ".", 3],
    [4, ".", ".", 8, ".", 3, ".", ".", 1],
    [7, ".", ".", ".", 2, ".", ".", ".", 6],
    [".", 6, ".", ".", ".", ".", 2, 8, "."],
    [".", ".", ".", 4, 1, 9, ".", ".", 5],
    [".", ".", ".", ".", 8, ".", ".", 7, 9]
]

if __name__ == "__main__":
    for row in sample_board:
        print(row)
    print("Is valid Sudoku?", isValidSudoku(sample_board))
