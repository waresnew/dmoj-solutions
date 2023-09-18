#include <bits/stdc++.h>

// 3/28/2023
using namespace std;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int TT;cin>>TT;
    for (int T = 0; T< TT; T++) {
        string s;cin>>s;
        stack<char> stack;
        for (char c : s) {
            if (c=='(') stack.push(c);
            if (c==')') {
                if (!stack.empty()&&stack.top()=='(') {
                    stack.pop();
                } else {
                    cout << "NO\n";
                    goto label;
                }
            }
        }
        cout << (stack.empty()?"YES\n":"NO\n");
        label:;
    }
}