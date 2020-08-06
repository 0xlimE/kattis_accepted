
#include <iostream>
#include <string>
#include <unordered_set>
#include <vector>
using namespace std;

void fastscan(int &number) 
{ 
    //variable to indicate sign of input number 
    bool negative = false; 
    register int c; 
  
    number = 0; 
  
    // extract current character from buffer 
    c = getchar(); 
    if (c=='-') 
    { 
        // number is negative 
        negative = true; 
  
        // extract the next character from the buffer 
        c = getchar(); 
    } 
  
    // Keep on extracting characters if they are integers 
    // i.e ASCII Value lies from '0'(48) to '9' (57) 
    for (; (c>47 && c<58); c=getchar()) 
        number = number *10 + c - 48; 
  
    // if scanned input has a negative sign, negate the 
    // value of the input number 
    if (negative) 
        number *= -1; 
} 

int main ()
{
  ios_base::sync_with_stdio(false); 
  cin.tie(NULL);  
  int jack;
  int jill;
  int in;
  std::unordered_set<int> myset;
  vector<int> v;
  while(true){
    myset.clear();
    fastscan(jack);
    fastscan(jill);
    if(jack == 0 && jill == 0 ){
        break;
    }
    for(int i = 0; i<jack; i++){
        fastscan(in);
        myset.insert(in);
    }
    int counter = 0;
    for(int i = 0; i<jill; i++){
        fastscan(in);
        std::unordered_set<int>::const_iterator got = myset.find(in);
        if ( got == myset.end()){

        }else{
            counter++;
        }
        
    }
    cout << counter << "\n"; 
    //v.push_back(counter);
  }
  /*
  for(int n : v) {
        std::cout << n << '\n';
  }*/
  
  return 0;
  



}


