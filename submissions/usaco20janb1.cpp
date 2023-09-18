#include <bits/stdc++.h>

// 12/12/2022
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n,k;
    cin>>n>>k;
    int line_count = 0;
    for (int i = 0; i < n; i++) {
        string word;
        cin>>word;
        if (line_count+word.length()<=k) {
            cout << (i==0?"":" ") << word;
            line_count+=word.length();
        } else {
            cout << "\n" << word;
            line_count=word.length();
        }
    }
    cout << "\n";
}