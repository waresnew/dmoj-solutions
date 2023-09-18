#include <bits/stdc++.h>

// 5/13/2023
using namespace std;
set<string> perms[33];
string rows[33];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int r,c;cin>>r>>c;
    for (int i = 0; i < r; ++i) {
        string s="";
        for (int j = 0; j < c; ++j) {
            string s1;cin>>s1;
            s+=s1;
        }
        rows[i]=s;
    }
    perms[0].insert(rows[0]);
    for (int i = 1; i < r; i++) {
        for (string prev : perms[i-1]) {
            string next = "";
            for (int j = 0; j < c; ++j) {
                next += to_string(stoi(to_string(prev[j]-'0'))^stoi(to_string(rows[i][j]-'0')));
            }
            perms[i].insert(next);
            perms[i].insert(rows[i]);
        }
    }
    cout << perms[r-1].size()<<"\n";
}