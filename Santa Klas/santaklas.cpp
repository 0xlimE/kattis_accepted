#include <iostream>
#include <string>
#include <cmath>
using namespace std;

int main ()
{
  int height;
  int degree;
  cin >> height;
  cin >> degree;
  if(degree > 180){
      double d = -1 * sin(degree*(M_PI/180));
      cout << floor(height/d);
  }else{
      cout << "safe";
      return 0;

  }

  return 0;
}