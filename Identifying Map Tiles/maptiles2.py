import sys
import math
inputfile = sys.stdin

line = inputfile.readline().strip()

length = len(line)

numTiles = 4**length

dim = int(math.sqrt(numTiles))

def getXY(level,number):
    toadd = 2**(length-level)
    if(number == 0):
        return 0,0
    elif(number == 1):
        return toadd,0
    elif(number == 2):
        return 0,toadd
    elif(number == 3):
        return toadd,toadd

x = 0
y = 0

for i in range(length):
    number = int(line[i])
    xadd, yadd = getXY(i+1,number)
    x += xadd
    y += yadd

print(length,x,y)

