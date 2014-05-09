import math
import re
import pdb

bfn = "73167176531330624919225119674426574742355349194934\
96983520312774506326239578318016984801869478851843\
85861560789112949495459501737958331952853208805511\
12540698747158523863050715693290963295227443043557\
66896648950445244523161731856403098711121722383113\
62229893423380308135336276614282806444486645238749\
30358907296290491560440772390713810515859307960866\
70172427121883998797908792274921901699720888093776\
65727333001053367881220235421809751254540594752243\
52584907711670556013604839586446706324415722155397\
53697817977846174064955149290862569321978468622482\
83972241375657056057490261407972968652414535100474\
82166370484403199890008895243450658541227588666881\
16427171479924442928230863465674813919123162824586\
17866458359124566529476545682848912883142607690042\
24219022671055626321111109370544217506941658960408\
07198403850962455444362981230987879927244284909188\
84580156166097919133875499200524063689912560717606\
05886116467109405077541002256983155200055935729725\
71636269561882670428252483600823257530420752963450"

def five_tuple_yielder(string):
    """returns a generator that will yield all the possible combinations
    of 5 groups of characters that can be made out of this string"""


def five_sum_yielder(total):
    """yields all the combination of 5 numbers where the sum is 'sum'
    The last number in the tuple has always to be same or bigger than the other 4"""

    def normal_range(to_incl):
        return range(1, to_incl+1)
    
    for a in normal_range(total):
        for b in normal_range(total - a):
            for c in normal_range(total - a - b):
                for d in normal_range(total - a - b - c):
                    max_i = max(a, b, c, d)
                    for e in normal_range(max_i):
                        if euler_8_p([a, b, c, d, e]):
                            yield [a, b, c, d, e]


def all_ints_with(digits):
    """returns a generator for all the ints with the amount of digits specified
    >>> list(all_ints_with(1))
    [[1], [2], [3], [4], [5], [6], [7], [8], [9]]
    >>> len(list(all_ints_with(2)))
    90
    """
    return (int_to_list_of_digits(x) for x in range(int(math.pow(10, max(digits-1, 0))), int(math.pow(10, digits))))


def sum_is_less_then_10_and_not_0_p(l):
    """
    >>> sum_is_less_then_10_and_not_0_p([1,2,3])
    True
    >>> sum_is_less_then_10_and_not_0_p([1,2,3,4])
    False
    >>> sum_is_less_then_10_and_not_0_p([0,1,2])
    False
    """

    return sum(l) < 10 and 0 not in l


def int_to_list_of_digits(integer):
    """
    >>> int_to_list_of_digits(123)
    [1, 2, 3]
    """
    return [int(x) for x in list(str(integer)) ]


def all_ints_with_p(digits, predicate):
    """returns a generator for all the ints with the amount of digits specified
    >>> list(all_ints_with_p(2, sum_is_less_then_10_and_not_0_p))
    [[1, 1], [1, 2], [1, 3], [1, 4], [1, 5], [1, 6], [1, 7], [1, 8], [2, 1], [2, 2], [2, 3], [2, 4], [2, 5], [2, 6], [2, 7], [3, 1], [3, 2], [3, 3], [3, 4], [3, 5], [3, 6], [4, 1], [4, 2], [4, 3], [4, 4], [4, 5], [5, 1], [5, 2], [5, 3], [5, 4], [6, 1], [6, 2], [6, 3], [7, 1], [7, 2], [8, 1]]
    """
    return (x for x in all_ints_with(digits) if predicate(x))


def euler_8_p(l):
    """
    >>> euler_8_p([2,3,1,5,1])
    False
    >>> euler_8_p([1,2,3,1,3])
    True
    >>> euler_8_p([2,3,1,5,7])
    False
    """
    if 0 in l:
        return False
    if sum(l) > 1000:
        return False
    if l[-1] < max(l[:-1]):
        return False
    if l[-1] > max(l[:-1]) + 1:
        return False

    return True


for x in five_sum_yielder(1000):
    print (x)