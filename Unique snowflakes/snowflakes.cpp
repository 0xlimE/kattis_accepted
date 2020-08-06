#include <iostream>
#include <string>
#include <map>
using namespace std;



int main ()
{
  int tests;
  cin >> tests;
  for(int i = 0; i<tests; i++){
      int snowflakes;
      cin >> snowflakes;
      int array [snowflakes];
      int read;
      for(int k = 0; k<snowflakes; k++){
          cin >> read;
          array[k] = read;
      }
      map<int,int> m;
      int best = 0;
      for(int k = 0; k<snowflakes; k++){
          if(m.find(array[k])!=m.end()){
            int size = m.size();
            best = max(best,size);
            k = m[(array[k])];
            m.clear();
          }else{
              
              m.insert(pair<int,int>(array[k],k));
          }
      }
      int size = m.size();
      cout << max(best,size) <<endl ;
  }
  return 0;
}