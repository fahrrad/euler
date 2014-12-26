__author__ = 'wardcoessens'

numbers = 'zero, one, two, three, four, five, six, seven, eight, nine'.split(', ')

speciallekes = {11: 'eleven', 12: 'twelve', 13: 'thirteen', 14: 'fourteen', 15: 'fifteen',
                16: 'sixteen', 17: 'seventeen', 18: 'eighteen', 19: 'nineteen'}

tientallen = 'zero, ten, twenty, thirty, forty, fifty, sixty, seventy, eighty, ninety'.split(", ")

honderd = 'hundred'

duizend = 'thousand'

def schijf_cijfer(n):
    _1000  = False
    _100 = False
    cijfer = ""

    if n >= 1000:
        m = n // 1000
        n -= m * 1000
        _1000 = True
        cijfer += numbers[m] + " " + duizend
        if n > 0:
            cijfer += " and "

    if n >= 100:
        m = n // 100
        n -= m * 100
        _100 = True
        cijfer += numbers[m] + ' ' + honderd
        if not _1000 and n > 0:
            cijfer += " and "

    if n >= 10:
        if n in speciallekes.keys():
            cijfer += speciallekes[n]
            n = 0
        else:
            m = n // 10
            n -= m * 10
            cijfer += tientallen[m]
            if n > 0:
                cijfer += '-'

    if n > 0:
        cijfer += numbers[n]

    return cijfer


def count_l(m):
    return len(m.replace(' ', '').replace('-', ''))

if __name__ == '__main__':
    print('123')
    print(schijf_cijfer(123))

    print(1002)
    print(schijf_cijfer(1002))

    print(342)
    print(schijf_cijfer(342))

    def l(x):
        print(x,)
        y = schijf_cijfer(x)
        print(y, end="\t")
        print(count_l(y), end="\t")
        return count_l(y)

    for x in range(1000):
        l(x)

    print(sum((l(x) for x in range(1, 1001))))