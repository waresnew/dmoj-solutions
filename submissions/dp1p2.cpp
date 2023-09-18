#include <bits/stdc++.h>

// 3/28/2023
using namespace std;
int dp[1001][1001];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;cin>>n;
    int coins[n+1]; for(int i = 1;i<=n;i++) {
        cin>>coins[i];
        dp[i][i]=coins[i];
        coins[i]+=coins[i-1];
    }
    for (int l = 1; l <= n; l++) {
        for (int i = 1; i+l <=n; ++i) {
            int j= i + l;
            dp[i][j]=coins[j]-coins[i-1]-min(dp[i+1][j], dp[i][j-1]);
        }
    }
    cout << dp[1][n]<<"\n";

}