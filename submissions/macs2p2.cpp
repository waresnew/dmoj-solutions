#include <bits/stdc++.h>

// 5/8/2023
using namespace std;
#define ll long long
ll ans;
int n,m;
int get_hash(string s) {
    int hash = 0;
    for (int i = 0; i < (int)s.size(); i++) {
        hash = hash * 13 + s[i] - 'a' + 1;
    }
    return hash;
}

void gen_pw(string cur) {
    if (cur.length()==n) {
        if (get_hash(cur)==m) {
            ans++;
        }
        return;
    }
    for (char c = 'a'; c <= 'z'; c++) {
        gen_pw(cur+c);
    }
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>n>>m;
    gen_pw("");
    cout << ans << "\n";
}