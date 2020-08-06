
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
  
  int nums;
  fastscan(nums);

  int arr[nums];
  int RiLo[nums];
  int LeHi[nums];

  int in;
  int highest = 0;
  for(int i = 0; i< nums; i++){
      fastscan(in);
      arr[i] = in;
      if(highest < in){
          highest = in;
      }
      LeHi[i] = highest;
  }
  
  int lowest = 100001;
  for(int i = nums-1; i>= 0; i--){
      if(arr[i] < lowest){
          lowest = arr[i];
      }
      RiLo[i] = lowest;
  }
  
  int total = 0;
  for(int i = 0; i<nums; i++){
      if(arr[i] == RiLo[i] && RiLo[i] == LeHi[i]){
          total++;
      }
  }
  cout << total;


  
  return 0;
  



}


