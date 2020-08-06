
#include <iostream>
#include <string>
#include <unordered_set>
#include <vector>
#include <math.h>

using namespace std;

int pre_calculated(int n){
    switch(n) {
    case 1 : return 1;
    case 2 : return 2;
    case 6 : return 3;
    case 24: return 4;
    case 120: return 5;
    case 720: return 6;
    }
}

int main ()
{
  ios_base::sync_with_stdio(false); 
  cin.tie(NULL);  
  string in;
  cin >> in;
  int length = in.length();

  if(length < 4){
      cout << pre_calculated(stoi(in));
  }else{
      int number = 6;
      double log_sum = log10(1) + log10(2)+ log10(3) + log10(4) + log10(5) + log10(6);

      while (true)
        {
            log_sum += log10(++number);
            if (log_sum > length)
            {
                printf("%d\n", number - 1);
                break;
            }
        }
    }
    return 0;
}







