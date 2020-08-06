#include <iostream>
#include <string>
#include <set>
#include <cmath>
using namespace std;

int main ()
{
  set<int> myset;
  int days;
  cin >> days;

  for(int i = 0; i<days; i++){
    int from;
    int to; 
    cin >> from;
    cin >> to;
    for(int t = from; t<to+1; t++){
        myset.insert(t);
    }
  }
  cout << myset.size();

  return 0;
}