#include <bits/stdc++.h>

// 4/9/2023
using namespace std;
int dp[1002][1002];
int grid[1002][1002];
int l, d;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin >> l >> d;
    memset(dp, 0x3f, sizeof(dp));
    for (int i = 1; i <= d; ++i) {
        for (int j = 1; j <= l; ++j) {
            cin >> grid[i][j];
        }
    }
    dp[1][1]=grid[1][1];
    for (int i = 1; i <= d; ++i) {
        for (int j = 1; j <= l; ++j) {
            dp[i][j]=min(dp[i][j], dp[i-1][j]+grid[i][j]);
            dp[i][j]=min(dp[i][j], dp[i][j-1]+grid[i][j]);
        }
        for (int j = l; j >=1; --j) {
            dp[i][j]=min(dp[i][j], dp[i][j+1]+grid[i][j]);
        }
    }
    int a,b;cin>>a>>b;
    cout << dp[b+1][a+1]<<"\n";
}