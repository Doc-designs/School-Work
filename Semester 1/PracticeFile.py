import unittest
# --------------------------------------------------------------
def largestoffour(a, b, c, d) :
    '''
    Assume that the four parameters are numbers.
    Return the largest of the four numbers.
    You cannot use the built-in max() function
    For example, if a is 9, and b is 7, and c is 7 and d is 9,
    then the function would return 9.
    '''
    larg = 0
    if (a >= b and a >= c) and a >= d:
        larg = a;
    if(b >= a and b >= c) and b >= d:
        larg = b;
    if (c >= a and c >= b) and c >= d:
        larg = c;
    if (d >= a and d >= b) and d >= c:
        larg = d;
    return larg

# --------------------------------------------------------------
# Adding up to the value 'Quit'
# --------------------------------------------------------------
def sumquit(L) :
    '''
    Assume that L is a list where one of the elements is 'Quit'.
    Return the sum of the numbers in L up to the word 'Quit'.
    For example, 
    sumquit(['Quit', 1, 2, 3]) returns 0
    sumquit([1, 2, 3,'Quit']) returns 6
    sumquit([1, 2, 3,'Quit', 4, 5, 9]) returns 6
    '''
    tot = 0
    for i in range(len(L)):
        if L[i] == 'Quit':
            break
        else:
            tot += L[i];
    return tot
# --------------------------------------------------------------
def series0(epsilon) :
    check = 0.0;
    counter = 1;
    while abs(4.23 - float(epsilon)) > check:
        check += float(1/counter)
        counter += 1;
    return counter-1

# --------------------------------------------------------------
# Trim front and back of string without recursion.
# --------------------------------------------------------------
def trim(S):
    starter = 0;
    ender = 0;
    for i in range(len(S)):
        if S[i] != ' ':
            starter = i;
            break
        if i+1 == len(S) and S[i] == ' ':
            return ''
    for i in range(1, len(S)):
        if S[-i] != ' ':
            if i == 1:
                ender = len(S)
            else:
                ender = -i;
            break
    return S[starter:ender+1]
# --------------------------------------------------------------
# Trim front and back of string with recursion.
# --------------------------------------------------------------
def rectrim(S):
    if len(S) > 0:
        if S[0] != " " and S[-1] != " ": 
            return S
        elif S[0] == " ":
            return rectrim(S[1:])
        elif S[-1] == " ":
            return rectrim(S[:-1])
    else:
        return ''
# --------------------------------------------------------------
# The Testing
# --------------------------------------------------------------
class myTests(unittest.TestCase):
 def test1(self):
  self.assertEqual(rectrim('    dog   '), 'dog')
 def test2(self):
  self.assertEqual(rectrim('    cat in the hat'), 'cat in the hat')
 def test3(self):
  self.assertEqual(rectrim(''), '')
 def test4(self):
  self.assertEqual(rectrim('      '), '')
 def test5(self):
  self.assertEqual(rectrim(' red green  blue  .'), 'red green  blue  .')


if __name__ == '__main__':
 unittest.main(exit=True)




# --------------------------------------------------------------
# The End
# --------------------------------------------------------------