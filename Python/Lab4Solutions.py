def timestable(n):
    numbList = []
    for row in range(n):
        numbList.append([])
        for col in range(n):
            numbList[row].append(col)
            numbList[row][col] = col+1
            if col == 0:
                numbList[row][0] = row+1
            numbList[row][col] = numbList[0][col] * numbList[row][0]
        print(*numbList[row])
if __name__ == "__main__":
    userInput = int(input("Enter a Value: "))
    timestable(userInput)
