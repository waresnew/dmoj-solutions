#include <bits/stdc++.h>

// 5/27/2023
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    string s;cin>>s;
    for (int i = 1; i < s.length(); i++) {
        bool a = regex_match(string(1,s[i-1]), regex("[aeiou]"));
        bool b = regex_match(string(1,s[i]), regex("[aeiou]"));
        if (!a^b) {
            cout << "NO\n";
            return 0;
        }
    }
    cout << "YES\n";
}