def root_solver(a, b, c):
    if b**2 - (4*a*c) < 0:
        return "has no solution"
    elif b**2 - (4*a*c) == 0:
        return int(-b/(2*a))
    else:
        return int((-b + ((b**2) - (4*a*c))**0.5)/(2*a)) , int((-b - ((b**2) - (4*a*c))**0.5)/(2*a))
print(root_solver(1, -4, 3))
