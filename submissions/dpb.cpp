#include <bits/stdc++.h>

// 2/13/2023
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n,k;cin>>n>>k;
    int a[n+1];
    for (int i = 1; i <= n; i++) cin>>a[i];
    int dp[n+1]; memset(dp, 0x3f, sizeof(dp));
    dp[1]=0;
    for (int i = 1; i <= n; i++) {
        for (int j = i+1; j <= min(n,i+k); j++) {
            dp[j]=min(dp[j], abs(a[j]-a[i])+dp[i]);

        }

    }
    cout << dp[n] << "\n";
}