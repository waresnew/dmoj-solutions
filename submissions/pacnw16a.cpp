#include <bits/stdc++.h>

// 3/28/2023
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    string s;
    cin >> s;
    vector<char> list;
    for (char c : s) {
        if (list.empty()||c>list.back()) list.push_back(c);
        else *lower_bound(list.begin(), list.end(), c)=c;
    }
    cout << 26-list.size()<<"\n";
}