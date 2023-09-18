#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;cin>>n;
    for (int test = 0; test < n; test++) {
        string sandwich; cin>>sandwich;
        stack<char> stack;
        for (int i = 0; i < sandwich.length(); i++) {
            if (sandwich[i]=='('||sandwich[i]=='['||sandwich[i]=='{') {
                stack.push(sandwich[i]);
            }
            if (sandwich[i]==')') {
                if (stack.empty()||stack.top()!='(') {
                    cout << "not tasty\n";
                    goto loop;
                } else {
                    stack.pop();
                }
            } else if (sandwich[i]==']') {
                if (stack.empty()||stack.top()!='[') {
                    cout << "not tasty\n";
                    goto loop;
                } else {
                    stack.pop();
                }
            } else if (sandwich[i]=='}') {
                if (stack.empty()||stack.top()!='{') {
                    cout << "not tasty\n";
                    goto loop;
                } else {
                    stack.pop();
                }
            }
        }
        cout << (stack.empty()?"tasty\n":"not tasty\n");
        loop:;
        
    }
    return 0;
}