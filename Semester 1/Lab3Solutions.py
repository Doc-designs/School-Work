def fourthRoot():
    N = int(input("Potential Perfect Fourth Root: "))
    guess = 0
    while guess ** 4 < N :
        guess = guess + 1
    if guess ** 4 != abs(N) :
        print(N + "is not a perfect root")
    else:
        print(guess + " is the fourth root of " + N)
        
def lowestPowerFinder():
    N = int(input("Find the root to the lowest power of: "))
    baseValue = 64
    basePower = 0
    while baseValue**basePower != N:
        baseValue -= 1
        basePower = 0
        prevGuess = baseValue**basePower
        if baseValue == 0:
            print("No Such Values")
        while baseValue**basePower < N:
            basePower += 1
            if prevGuess == baseValue**basePower:
                break
    print("The root is: " + baseValue + ", and it's to the power of: " + basePower)
    
def lowestRootFinder():
    N = int(input("Find the lowest root of: "))
    baseValue = 0
    basePower = 0
    while baseValue**basePower != N:
        baseValue += 1
        basePower = 0
        prevGuess = baseValue**basePower
        if baseValue > N:
            print("No Such Values")
        while baseValue**basePower < N:
            basePower += 1
            if prevGuess == baseValue**basePower:
                break
    print("The root is: " + baseValue + ", and it's to the power of: " + basePower)

def repeater():
    P = input("Type a Phrase: ")
    R = int(input("# of repeats: "))
    for i in range(R):
        print(P)

def oddsAtLarge():
    largestEntry = 0
    workingValue = False
    for i in range(10):
        N = int(input("Enter a Value: "))
        if N % 2 != 0 and N > largestEntry:
            workingValue = True
            largestEntry = N
    if workingValue == True:
        print(largestEntry)
    else:
        print("No Viable Values")

def extractingStringInts():
    S = input("Enter a String Containing Numbers: ")
    N = 0
    for i in range(len(S)):
        if S[i].isdigit():
            N = N + int(S[i])
    print(N)

def addingFloats():
    N = 0.0
    S = input("Enter a List of Decimal Numbers Seperated by Comma's: ")
    S = S.split(',')
    for i in range(len(S)):
        N += float(S[i])
    print(N)

def sqrRtFinder():
    x = int(input("Enter A Positive Value to Find its Square Root: "))
    while x < 0:
        x = int(input("Enter A Positive Value to Find its Square Root: "))
    epsilon = 0.1
    low = 0.0
    high = max(1.0, x)
    guess = (low + high) / 2
    numberofguesses = 1
    while abs(guess ** 2 - x) > epsilon :
        numberofguesses += 1
        print("low =", low, "high = ", high, "guess = ", guess)
        if guess** 2 > x : 
            high = guess
        else : 
            low = guess
        guess = (low + high) / 2
    print("number of guesses:", numberofguesses)
    print(guess, "is close enough to the square root of ", x)
    
def cubeRtFinder():
    x = int(input("Enter A Value to Find its Cube Root: "))
    if x < 0:
        equat = -1
    else:
        equat = 1
    epsilon = 0.1
    low = 0.0
    high = max(1.0, x*equat)
    guess = (low + high) / 2
    numberofguesses = 1
    while abs(guess ** 3 - (x*equat)) > epsilon :
        numberofguesses += 1
        print("low =", low, "high = ", high, "guess = ", guess)
        if guess** 3 > (x*equat) : 
            high = guess
        else : 
            low = guess
        guess = (low + high) / 2
    print("number of guesses:", numberofguesses)
    print(guess*equat, "is close enough to the cube root of ", x)

def binifier():
    N = int(input("Enter A Positive Int: "))
    NH = N
    Bin = ""
    while NH > 0:
        NH = N//2
        Bin = str(N%2) + Bin
        N = NH
    print(Bin)

def first_last6(nums):
  if nums[0] == 6 or nums[-1] == 6:
    return True
  else:
    return False

def same_first_last(nums):
  if len(nums) >= 1:
    if nums[0] == nums[-1]:
      return True
    else:
      return False
  else: 
    return False

def make_pi():
  return [3, 1, 4]

def common_end(a, b):
  if a[0] == b[0] or a[-1] == b[-1]:
    return True
  else:
    return False

def sum3(nums):
  return nums[0] + nums[1] + nums[2]

def rotate_left3(nums):
  newlist = []
  for i in range(len(nums)):
    newlist.insert(i-1, nums[i])
  return newlist

def reverse3(nums):
  newlist = []
  for i in range(len(nums)):
    newlist.insert(i, nums[2-i])
  return newlist

def max_end3(nums):
  max = 0
  if nums[0] > nums[-1]:
    max = nums[0]
  else:
    max = nums[-1]
  for i in range(len(nums)):
      nums[i] = max
  return nums

def sum2(nums):
  if len(nums) >= 2:
    return nums[0] + nums[1]
  elif len(nums) == 1:
    return nums[0]
  else:
    return 0

def middle_way(a, b):
  newlist = []
  newlist.append(a[1])
  newlist.append(b[1])
  return newlist

def make_ends(nums):
  return [nums[0], nums[-1]]

def has23(nums):
  for i in range(len(nums)):
    if nums[i] == 2 or nums[i] == 3: return True
  return False

