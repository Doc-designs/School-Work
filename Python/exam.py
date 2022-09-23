#!/usr/bin/python3
import unittest
# --------------------------------------------------------------
# Urine Ketone Levels chart 
# (Caveat: just an excercise, not true)
# --------------------------------------------------------------
def urineketone(mmolL, diabetes) :
    '''
    Assume that mmolL is a number representing mmol of ketones per L of urine,
    and diabetes is True or False.
    Returns 
    in the case that diabetes is False:
      'Normal' if mmolL is less than 0.5
      'Ketosis' if mmolL is 0.5 to 3, inclusive
      'Starvation ketosis' if mmolL is above 3 and <= 5
      'Call Doctor' if mmolL is greater than 5,
    and in the case that diabetes is True:
      'Normal' if mmolL is less than 0.5
      'Ketosis' if mmolL is 0.5 to 1.5, inclusive
      'High ketosis, risk DKA' if mmolL is above 1.5 and <= 3
      'Call Doctor' if mmolL is greater than 3,

    For example, 
    urineketone(0.4, False) returns Normal
    urineketone(0.5, True) returns Ketosis
    urineketone(5, True) returns Call Doctor
    urineketone(3, False) returns Starvation Ketosis
    '''
    if diabetes is False:
        if mmolL < 0.5:
            return "Normal"
        elif mmolL >= 0.5 and mmolL <= 3:
            return "Ketosis"
        elif mmolL > 3 and mmolL <= 5:
            return 'Starvation Ketosis'
        else:
            return "Call Doctor"
    else:
        if mmolL < 0.5:
            return "Normal"
        elif mmolL >= 0.5 and mmolL <= 1.5:
            return "Ketosis"
        elif mmolL > 1.5 and mmolL <= 3:
            return 'High ketosis, risk DKA'
        else:
            return "Call Doctor"
    
# --------------------------------------------------------------
# Jump to 1
# --------------------------------------------------------------
def jumpTo1(level):
    """
    Assumes that level is a positive integer.
    Returns the number of steps required to change level to 1, where
    a step is either
    (i) if level is even, change level to half of level
    (ii) if level is odd, change level to 3 * level + 1
    You can assume that these steps always lead to level 1.
    
    For example:
    jumpTo1(3) returns 7 since 
       (1) 3*3+1 = 10, 
       (2) 10//2 = 5, 
       (3) 3 * 5 + 1 = 16, 
       (4) 16/2 = 8,
       (5) 8/2 = 4, 
       (6) 4/2 = 2, 
       (7) 2/2 = 1
    """
    steps = 0
    while level > 1:
      if level % 2 == 0:
        level = level / 2
        steps += 1
      else:
        level = 3*level + 1
        steps += 1
    return steps
# --------------------------------------------------------------
# Find nested string
# --------------------------------------------------------------
def findString(S,targetDepth) :
    '''
    Assume that S is a string, targetDepth is an integer.
    Return the string of all characters at the specified nested depth
    where depth is signified by parentheses, such that 
    depth 0 means not inside parentheses,
    depth 1 means inside one pair of parentheses, such as (a)
    depth 2 means inside two pairs of parentheses, such as ((a))
    and so on.  You can assume that parentheses are balanced.

    For example,
    findString('abc(def)g',0) returns 'abcg'
    findString('abc(def)g',1) returns 'def'
    findString('abc(def)g',2) returns ''
    findString('((q))abc(d(r)ef(s))g((t))',2) returns 'qrst'
    '''
    retString = ""
    activeVal = [False, False]
    for i in range(len(S)):
        if S[i] == "(" and activeVal[0] == False:
            activeVal[0] = True
        elif S[i] == "(" and activeVal[1] == False:
            activeVal[1] = True
        elif S[i] == ")" and activeVal[1] == True:
            activeVal[1] = False
        elif S[i] == ")" and activeVal[0] == True:
            activeVal[0] = False
            
        elif targetDepth == 0 and activeVal[0] == False:
            retString += S[i]
        elif targetDepth == 1 and activeVal[0] == True:
            retString += S[i]
        elif targetDepth == 2 and activeVal[1] == True:
            retString += S[i]
    return retString


# --------------------------------------------------------------
# Find the item with the greatest weight
# --------------------------------------------------------------
def greatestWeight(L):
    '''
    Assumes L is a nonempty list of pairs (item, weight). 
    An item may occur in more than one tuple, in which case 
    its total weight is the sum of the weights in its tuples.
    Return the item with the greatest cumulative weight.
    (In the case of a tie, return any item of greatest cumulative weight).

    CONSTRAINT: YOU MUST USE A DICTIONARY.

    For example,
    greatestWeight([('item1', 3)]) returns 'item1'
    greatestWeight([('item1', 3),('item2', 2)]) returns 'item1'
    greatestWeight([('item2', 2),('item1', 3),('item2', 2)]) returns 'item2'
    '''
    weightDict = {"item1": 0, "item2": 0}
    for i in range(len(L)):
        if L[i][0] == 'item1':
            weightDict["item1"] += L[i][1]
        else:
            weightDict["item2"] += L[i][1]
    if weightDict["item1"] > weightDict["item2"]:
        return "item1"
    else:
        return "item2"
#-----------------------------------
def recursiveSum(l) :
    '''
    Assumes l is a number or a list of numbers and lists (of numbers and lists of ...).
    Returns the sum of all the numbers

    You must use RECURSION to solve the problem.

    For example, 
    recursiveSum(5) is 5
    recursiveSum([1,[[[[2]]]]]) is 3

	Note that type([1])==list
    '''
    if type(l) == int or len(l) == 1:
        return int(l)
    elif l != []:
        return recursiveSum(l[0:-1])
    else:
        return 0
# --------------------------------------------------------------
# TEST CASES
# --------------------------------------------------------------