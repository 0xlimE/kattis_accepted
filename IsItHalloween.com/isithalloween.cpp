#include <iostream>
#include <string>
using namespace std;

int main() 
{
    string temp;
    getline(cin,temp);
    if(temp == "DEC 25" || temp == "OCT 31"){
        cout << "yup";
    }else{
        cout << "nope";
    }
    return 0;
}