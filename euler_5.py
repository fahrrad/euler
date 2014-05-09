import math
import operator 
from itertools import count, islice

def dividable_p(x):
    for y in range(2,21):
        if x % y != 0: return False
    return True
    
seq = (x for x in count(20) if dividable_p(x))
print (list(islice(seq, 0,1)))


