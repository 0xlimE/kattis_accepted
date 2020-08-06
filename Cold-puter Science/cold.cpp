
#include <iostream>
using namespace std;


int main ()
{
  int nums , in , counter;
  cin >> nums;
  counter = 0;
  for(int i = 0; i<nums; i++){
      cin >> in;
      if(in < 0){
          counter++;
      }
  }
  cout << counter;

  return 0;
}


