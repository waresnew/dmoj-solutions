#include <bits/stdc++.h>

// 5/27/2023
using namespace std;
int n,d;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>n>>d;
    long long ans= 0;
    int cur = 0;
    long long offset = 0;
    for (int i = 0; i < n; ++i) {
        int pos,red,green;cin>>pos>>red>>green; //light is always in front of you
        int time = (pos % (red + green)+offset)%(red+green);
        ans += pos-cur;
        if (time <= red) {
            ans += red-time;
            offset += red-time;
        }
        cur = pos;

    }
    if (cur!=d) {
        ans += d-cur;
    }
    cout << ans << "\n";
}