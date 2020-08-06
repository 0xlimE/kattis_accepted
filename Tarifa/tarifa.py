import sys

file1 = sys.stdin
totalRemainingMB = 0

X = int(file1.readline())
N = int(file1.readline())



for month in file1:
    usedMB = int(month)
    monthRemainingMB = X-usedMB
    totalRemainingMB = totalRemainingMB + monthRemainingMB

print(totalRemainingMB+X)