
#include <iostream>
using namespace std;


int main ()
{
  int nums , in;
  cin >> nums;
  for(int i = 0; i<nums; i++){
      cin >> in;
      if(in % 2 == 0){
          cout << in << " is even"<<"\n";
      }else{
          cout << in << " is odd" <<"\n";
      }
  }

  return 0;
}


