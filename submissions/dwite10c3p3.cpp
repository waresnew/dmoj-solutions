#include <bits/stdc++.h>

// 4/30/2023
using namespace std;
int dp[33];
int mod = 1000000;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    for (int T = 0; T < 5; T++) {
        memset(dp, 0, sizeof(dp));
        int n;cin>>n;
        dp[0]=1;dp[2]=3;
        for (int i = 4; i <= n; i+=2) {
            dp[i] = dp[i-2]*3;
            for (int j = i-4; j >= 0; j-=2) {
                dp[i]=(dp[i]+dp[j]*2)%mod;
            }
        }
        cout << dp[n]<<"\n";
    }
}