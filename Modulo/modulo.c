
#include <stdio.h>

int main()
{
    int lookup[42];
    for(int i =0; i<42; i++){
        lookup[i] = 0;
    }
    
    int list[10];
    int value;
    int counter = 0;
    for(int i = 0; i<10; i++){
        scanf("%d", &value);
        if(lookup[value % 42] == 0){
            counter = counter + 1;
            lookup[value % 42] = 1;
        }
    }
    printf("%d",counter);
    return 0;
}
