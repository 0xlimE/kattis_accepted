#include <iostream>
#include <string>
#include <cmath>
using namespace std;

int main ()
{
  int years;
  int days;
  cin >> years;
  cin >> days;
  int counter = 0;
  int temp;
  for(int i = 0; i<years; i++){
      cin >> temp;
      if(days >= temp){
          cout << "It hadn't snowed this early in "<< counter << " years!";
          return 0;
      }else{
          counter++;
      }
  }
  cout << "It had never snowed this early!";

  return 0;
}