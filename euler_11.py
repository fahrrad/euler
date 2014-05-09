import itertools
import math
import pdb

def triangle_generator():
    total = 0
    for x in itertools.count(1):
        total += x
        # print total
        yield total

known_dividers = {}

def find_divisors(x, known_dividers):
    dividers = set([1,x])
    
    i = x
    j = max(2,int(math.floor(x / 2)))
    print "find div for ", i
    print "knows ", known_dividers
    
    while(True):
        print("trying", j)

        if i/j in known_dividers:
            print "recept found for ", i, known_dividers[i/j]
            for x in known_dividers[i/j]:
                print "adding %d to the dividers( from recept)" % x
                dividers.add(x)

            print("now I know of %d dividers" % len(dividers))
            return dividers

        if j <= 1:
            print "reached the end, for %d, returning %s" % (x, dividers)
            return dividers

        if not i % j:
            print ("found divider for %d: %d" % (i,j))
            dividers.add(j)
            # i /= j
            dividers.add(i/j)

        j -= 1
        
def find_divisors_brute(x):
    """returns a list of divisors for x"""
    divisors = [1,x]
    max_div = math.floor(x / 2)
    for i in range(2,int(max_div) + 1):
        if not x % i: 
            divisors.append(i)
            # print "found div ", i
            continue

    return set(divisors)

print max(itertools.takewhile(lambda x: x < 10, triangle_generator()))

def less_then_100_p(x):
    return x < 100


for t in  triangle_generator():
    print "next triangle: ", t
    dividers = find_divisors(t, known_dividers)
    print "Dividers for %d :"%t , dividers
    known_dividers[t] = dividers
    l = len(dividers)
    if l % 10 == 0:
        print t, l
    if l > 4:
        break
