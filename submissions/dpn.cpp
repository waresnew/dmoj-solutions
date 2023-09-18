#include <bits/stdc++.h>

// 4/9/2023
using namespace std;
int n;
long long psa[403], dp[403][403];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> psa[i];
        psa[i] += psa[i - 1];
    }
    for (int len = 1; len <= n; len++) {
        for (int l = 1, r = l + len; r <= n; l++, r++) {
            dp[l][r]=LONG_LONG_MAX;
            for (int m = l; m < r; m++) {
                dp[l][r]=min(dp[l][r], dp[l][m]+dp[m+1][r]+psa[r]-psa[l-1]);
            }
        }
    }
    cout << dp[1][n]<<"\n";
}