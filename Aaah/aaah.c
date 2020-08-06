

#include <stdio.h> 
#define MAX_LIMIT 1001
int main() 
{ 
   char str1[MAX_LIMIT];
   char str2[MAX_LIMIT]; 
   gets(str1);
   gets(str2);
   if(strlen(str1) >= strlen(str2)){
       printf("go");
   }
   else{
       printf("no");
   }
   return 0; 
} 

