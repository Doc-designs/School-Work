def findNum():
    numSum = 0
    currentGuess = 0
    while int(currentGuess) != -1:
        currentGuess = input("Enter A Number: ")
        if int(currentGuess) != -1:
            numSum += int(currentGuess)
    return print(numSum)

