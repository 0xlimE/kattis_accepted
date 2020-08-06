
#include <iostream>
#include <string>
#include <cmath>
#include <vector>
#include <algorithm>
using namespace std;




int main ()
{
  char ch;
  int index = 0;
  string line;
  getline(cin,line);
  char toPrint [line.length()];
  for(int i = 0; i<line.length(); i++){
      ch = line.at(i);
      if(ch == '<'){
          index--;
      }else{
          toPrint[index] = ch;
          index++;
      }
  }
  for(int i = 0; i<index; i++){
      cout << toPrint[i];
  }

  return 0;
}


