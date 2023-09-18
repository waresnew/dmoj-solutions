#include <bits/stdc++.h>

// 3/7/2023
using namespace std;
int dp[1001][1001];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n,m;cin>>n>>m;
    int a[n+1], b[m+1];
    for (int i = 1; i <= n; i++) cin>>a[i];
    for (int i = 1; i <= m; i++) cin>>b[i];
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= m; j++) {
            if (a[i]==b[j]) {
                dp[i][j]=dp[i-1][j-1]+1;
            } else {
                dp[i][j]=max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }
    cout << dp[n][m]<<"\n";
}