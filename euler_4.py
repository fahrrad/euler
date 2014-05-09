def productYielder():
    for i in range(100,1000):
        for j in range(100,1000):
            yield i,j

def palindrome_p(n):
    str_n = str(n)
    return str_n == str_n[::-1]

palindrome_products = [x*y for x,y in productYielder() if palindrome_p(x*y)]
print max(palindrome_products)
