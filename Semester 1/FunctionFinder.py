#The purpose of this program is to find the basic numerical function behind a pattern of numbers
#this first function is an altered version of the cube root fuction from Lab 3 designed to handle a variety of roots, numb is the int input and rt is the current root im using
def general_rt_finder(numb, rt):
    if numb < 0:
        equat = -1
    else:
        equat = 1
    epsilon = 0.1
    low = 0.0
    high = max(1.0, numb*equat)
    guess = (low + high) / 2
    numberofguesses = 1
    while abs(guess ** rt - (numb*equat)) > epsilon :
        numberofguesses += 1
        if guess** rt > (numb*equat) : 
            high = guess
        else : 
            low = guess
        guess = (low + high) / 2
    return int(guess)
#This is my main function, which has the user enter a list of 3 or more positive numbers to see if there is a mathmatical pattern
#most of the chunks of code in it are very similar, but are just in charge of different possible instances, so i've just commented where necessary
def function_finder():
    itemList = []
    #active loop is used to deactivate my while loops throughout the function under certain conditions
    activeLoop = True
    #a loop to collect a list of int inputs from the user
    while activeLoop == True:
        if len(itemList) < 1:
            userInput = input("Enter a Starting Number as a Positive Value: ")
        elif len(itemList) < 3 and userInput == "":
            userInput = input("3 Value Minimum, Enter a Number as a Positive Value That Follows an Organized Pattern: ")
        else:
            print("Just Press Enter if Finished")
            userInput = input("Enter a Number as a Positive Value That Follows an Organized Pattern: ")
        #This deactivates the while loop
        if len(itemList) >= 3 and userInput == "":
            activeLoop = False
        else:
            itemList.append(int(userInput))
    #prep for a second while loop
    activeLoop = True
    #I use this variable to make sure the numerical pattern remains true for all elements within the list
    applicable = len(itemList)
    #this is what I return at the end of the function
    solutions = ""
    #I increase n every itteration of the while loop, the reason I dont use a for loop is due to being unsure of what range I might need for this particular pattern
    n = 0
    while activeLoop == True:
        #this just tests if the elements in the list are equivilent
        if itemList[0] == itemList[1]:
            #this for loop checks if the pattern it detects from element 0 and 1 remain true throughout, I subtract one so the range of the list is not exceeded
            for i in range(len(itemList)-1):
                #checks if the current item is equal to the following item
                if itemList[i] == itemList[i+1]:
                    #for every element that it is true for, 1 is subtracted from applicable
                    applicable -= 1
                    #if applicable only has a remainder of 1 and there is no current solution, it sets one. We check for a remainder of 1 instead of 0 since technically we arent cursing through the entire list one by one
                    if applicable == 1 and solutions == "":
                        solutions = "Values are unchanging"
                    #if there is a current solution already detected, the program will list out possible functions that are behind the pattern
                    elif applicable == 1:
                        solutions = "Unclear, Possible Solutions: " + solutions + ", Values are unchanging"
                #if the pattern is broken, then applicable is reset to its default value and we exit the for loop
                else:
                    applicable = len(itemList)
                    break
        #if element 0 + n is equal to element 1, it proceeds to test if that pattern is upheld throughout the list, similar to first if statement
        if itemList[0]+n == itemList[1]:
            for i in range(len(itemList)-1):
                if itemList[i]+n == itemList[i+1]:
                    applicable -= 1
                    if applicable == 1 and solutions == "":
                        solutions = "Values are the previous plus " + str(n)
                    elif applicable == 1:
                        solutions = "Unclear, Possible Solutions: " + solutions + ", Values are the previous plus " + str(n)
                else:
                    applicable = len(itemList)
                    break
        #if element 0 - n is equivilent to element 1, similar to first and second if statement
        if itemList[0]-n == itemList[1]:
            for i in range(len(itemList)-1):
                if itemList[i]-n == itemList[i+1]:
                    applicable -= 1
                    if applicable == 1 and solutions == "":
                        solutions = "Values are the previous minus " + str(n)
                    elif applicable == 1:
                        solutions = "Unclear, Possible Solutions: " + solutions + ", Values are the previous minus " + str(n)
                else:
                    applicable = len(itemList)
                    break
        #This for loop is used to help account for instances where the pattern is something such as multiplication, as well as addition or subtraction
        for j in range(0, max(itemList)):
            #if element 0 times n equals element 1, similar to other if statements
            if itemList[0]*n == itemList[1]:
                for i in range(len(itemList)-1):
                    if itemList[i]*n == itemList[i+1]:
                        applicable -= 1
                        if applicable == 1 and solutions == "":
                            solutions = "Values are the previous multiplied by " + str(n)
                        elif applicable == 1:
                            solutions = "Unclear, Possible Solutions: " + solutions + ", Values are the previous multiplied by " + str(n)
                    else:
                        applicable = len(itemList)
                        break
            #This elif handles instances where the pattern is multiplied then added to
            elif (itemList[0]*n)+j == itemList[1]:
                for i in range(len(itemList)-1):
                    if (itemList[i]*n)+j == itemList[i+1]:
                        applicable -= 1
                        if applicable == 1 and solutions == "":
                            solutions = "Values are the previous multiplied by " + str(n) + " then adding " + str(j) 
                        elif applicable == 1:
                            solutions = "Unclear, Possible Solutions: " + solutions + ", Values are the previous multiplied by " + str(n) + " then adding " + str(j) 
                    else:
                        applicable = len(itemList)
                        break
            #This elif handles instances where the pattern is multiplied then subtracted from
            elif (itemList[0]*n)-j == itemList[1]:
                for i in range(len(itemList)-1):
                    if (itemList[i]*n)-j == itemList[i+1]:
                        applicable -= 1
                        if applicable == 1 and solutions == "":
                            solutions = "Values are the previous multiplied by " + str(n) + " then subtracting " + str(j) 
                        elif applicable == 1:
                            solutions = "Unclear, Possible Solutions: " + solutions + ", Values are the previous multiplied by " + str(n) + " then subtracting " + str(j) 
                    else:
                        applicable = len(itemList)
                        break
            #to avoid an error due to dividing by 0 it sets a pre-req that n is greater than 0
            if n > 0:
                #if element 0 divided by n is equal to element 1, similar to other if statements
                if itemList[0]/n == itemList[1]:
                    for i in range(len(itemList)-1):
                        if itemList[i]/n == itemList[i+1]:
                            applicable -= 1
                            if applicable == 1 and solutions == "":
                                solutions = "Values are the previous divided by " + str(n)
                            elif applicable == 1:
                                solutions = "Unclear, Possible Solutions: " + solutions + ", Values are the previous divided by " + str(n)
                        else:
                            applicable = len(itemList)
                            break
                #This elif handles instances where the pattern is divided then added to
                elif (itemList[0]/n)+j == itemList[1]:
                    for i in range(len(itemList)-1):
                        if (itemList[i]/n)+j == itemList[i+1]:
                            applicable -= 1
                            if applicable == 1 and solutions == "":
                                solutions = "Values are the previous divided by " + str(n) + " then adding " + str(j)
                            elif applicable == 1:
                                solutions = "Unclear, Possible Solutions: " + solutions + ", Values are the previous divided by " + str(n) + " then adding " + str(j)
                        else:
                            applicable = len(itemList)
                            break
                #This elif handles instances where the pattern is divided then subtracted from
                elif (itemList[0]/n)-j == itemList[1]:
                    for i in range(len(itemList)-1):
                        if (itemList[i]/n)-j == itemList[i+1]:
                            applicable -= 1
                            if applicable == 1 and solutions == "":
                                solutions = "Values are the previous divided by " + str(n) + " then subtracting " + str(j)
                            elif applicable == 1:
                                solutions = "Unclear, Possible Solutions: " + solutions + ", Values are the previous divided by " + str(n) + " then subtracting " + str(j)
                        else:
                            applicable = len(itemList)
                            break
            #to prevent an error resulting in an an unending function call, checks if n is greater than 0
            if n > 0:
                #if the root n of element 0 is equal to element 1, similar to other if statements
                if general_rt_finder(itemList[0], n) == itemList[1]:
                    for i in range(len(itemList)-1):
                        if general_rt_finder(itemList[i], n) == itemList[i+1]:
                             applicable -= 1
                             if applicable == 1 and solutions == "":
                                 solutions = "Values are the " + str(n) + " root of the previous"
                             elif applicable == 1:
                                 solutions = "Unclear, Possible Solutions: " + solutions + ", Values are the " + str(n) + "root of the previous"
                         else:
                             applicable = len(itemList)
                             break
                #This elif handles instances where the pattern is the root then added to
                elif (general_rt_finder(itemList[0], n))+j == itemList[1]:
                     for i in range(len(itemList)-1):
                         if (general_rt_finder(itemList[i], n))+j == itemList[i+1]:
                             applicable -= 1
                             if applicable == 1 and solutions == "":
                                 solutions = "Values are the " + str(n) + " root of the previous" + " then adding " + str(j)
                             elif applicable == 1:
                                 solutions = "Unclear, Possible Solutions: " + solutions + ", Values are the " + str(n) + "root of the previous" + " then adding " + str(j)
                         else:
                             applicable = len(itemList)
                             break
                #This elif handles instances where the pattern is the root then subtracted from
                elif (general_rt_finder(itemList[0], n))-j == itemList[1]:
                     for i in range(len(itemList)-1):
                         if (general_rt_finder(itemList[i], n))-j == itemList[i+1]:
                             applicable -= 1
                             if applicable == 1 and solutions == "":
                                 solutions = "Values are the " + str(n) + " root of the previous" + " then subtracting " + str(j)
                             elif applicable == 1:
                                 solutions = "Unclear, Possible Solutions: " + solutions + ", Values are the " + str(n) + "root of the previous" + " then subtracting " + str(j)
                         else:
                             applicable = len(itemList)
                             break
            #if element 0 to the power of n is equal to element 1, similar to other if statements
            if itemList[0]**n == itemList[1]:
                for i in range(len(itemList)-1):
                    if itemList[i]**n == itemList[i+1]:
                        applicable -= 1
                        if applicable == 1 and solutions == "":
                            solutions = "Values are the previous to the exponent of " + str(n)
                        elif applicable == 1:
                            solutions = "Unclear, Possible Solutions: " + solutions + ", Values are the previous to the exponent of " + str(n)
                    else:
                        applicable = len(itemList)
                        break
            #This elif handles instances where the pattern is the exponent then added to
            elif (itemList[0]**n)+j == itemList[1]:
                for i in range(len(itemList)-1):
                    if (itemList[i]**n)+j == itemList[i+1]:
                        applicable -= 1
                        if applicable == 1 and solutions == "":
                            solutions = "Values are the previous to the exponent of " + str(n) + " then adding " + str(j)
                        elif applicable == 1:
                            solutions = "Unclear, Possible Solutions: " + solutions + ", Values are the previous to the exponent of " + str(n) + " then adding " + str(j)
                    else:
                        applicable = len(itemList)
                        break
            #This elif handles instances where the pattern is the exponent then subtracted from
            elif (itemList[0]**n)-j == itemList[1]:
                for i in range(len(itemList)-1):
                    if (itemList[i]**n)-j == itemList[i+1]:
                        applicable -= 1
                        if applicable == 1 and solutions == "":
                            solutions = "Values are the previous to the exponent of " + str(n) + " then subtracting " + str(j)
                        elif applicable == 1:
                            solutions = "Unclear, Possible Solutions: " + solutions + ", Values are the previous to the exponent of " + str(n) + " then subtracting " + str(j)
                    else:
                        applicable = len(itemList)
                        break
        #if n is greater than the largest item in the list, end the while loop
        if n > max(itemList):
            activeLoop = False
        #increase n by 1 every itteration of the while loop
        n += 1
    #if no recognized pattern, return as such
    if solutions == "": solutions = "no recognized pattern"
    #return the list as well as any possible solutions that were found
    return print(itemList, solutions)       
if __name__ == "__main__":
    function_finder()
