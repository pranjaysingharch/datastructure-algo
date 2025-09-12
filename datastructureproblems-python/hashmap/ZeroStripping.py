def setZeroes(matrix):
    rows, cols = len(matrix), len(matrix[0])
    first_row_has_zero = any(matrix[0][c] == 0 for c in range(cols))
    first_col_has_zero = any(matrix[r][0] == 0 for r in range(rows))

    # Mark rows and cols
    for r in range(1, rows):
        for c in range(1, cols):
            if matrix[r][c] == 0:
                matrix[r][0] = 0
                matrix[0][c] = 0

    # Zero cells based on markers
    for r in range(1, rows):
        for c in range(1, cols):
            if matrix[r][0] == 0 or matrix[0][c] == 0:
                matrix[r][c] = 0

    # Zero first row
    if first_row_has_zero:
        for c in range(cols):
            matrix[0][c] = 0

    # Zero first col
    if first_col_has_zero:
        for r in range(rows):
            matrix[r][0] = 0

matrix=[
 [1, 2, 3],
 [4, 1, 6],
 [7, 0, 9]
]

if __name__ == "__main__":
    print(setZeroes(matrix))
