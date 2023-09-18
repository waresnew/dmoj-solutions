#include <bits/stdc++.h>

// 4/2/2023
using namespace std;
long long dp[3001][3001];
long long coins[3001];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;cin>>n;
    for(int i = 1;i<=n;i++) {
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
    cout << dp[1][n]-(coins[n]-dp[1][n])<<"\n";

}