#include <bits/stdc++.h>

// 3/7/2023
using namespace std;
int dp[55001];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n,m;cin>>n>>m;
    for (int i = 0; i < n; ++i) {
        int v,w;cin>>v>>w;
        for (int j = w; j <=m+5000;j++) {
            dp[j]=max(dp[j], dp[j-w]+v);
        }
    }
    for (int i = 0; i <= m+5000; i++) {
        if (dp[i]>=m) {
            cout << i << "\n"; break;
        }
    }
}