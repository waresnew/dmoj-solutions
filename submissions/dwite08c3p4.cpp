#include <bits/stdc++.h>

// 3/7/2023
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    for (int T = 0; T < 5; T++) {
        int cash;cin>>cash;
        int n;cin>>n;
        int coins[n]; for (int i = 0; i < n; i++) cin>>coins[i];
        int dp[cash+1]; for (int i = 1; i <=cash; i++) dp[i]=-1e9;
        dp[0]=0;
        for (int i = 0; i < n; ++i) {
            for (int j = coins[i]; j <= cash; ++j) {
                dp[j]=max(dp[j], dp[j-coins[i]]-1);
            }
        }
        cout << -dp[cash] << "\n";
    }
}