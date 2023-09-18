#include <bits/stdc++.h>
using namespace std;
long long dp[11][1 << 11][101], n, k;

int main() {
    cin >> n >> k;
    for (int mask = 0; mask < 1 << n; mask++) {
        if (__builtin_popcount(mask) > k) {
            continue;
        }
        if ((mask >> 1 & mask) == 0) {
            dp[0][mask][__builtin_popcount(mask)] = 1;
        }
    }

    for (int i = 1; i < n; i++) {
        for (int mask = 0; mask < 1 << n; mask++) {
            for (int total_king = __builtin_popcount(mask); total_king <= k; total_king++) {
                for (int prev_mask = 0; prev_mask < 1 << n; prev_mask++) {
                    if (!(mask & prev_mask || mask >> 1 & prev_mask || mask << 1 & prev_mask)) {
                        if ((mask >> 1 & mask) == 0) {
                            dp[i][mask][total_king] += dp[i - 1][prev_mask][total_king - __builtin_popcount(mask)];
                        }
                    }
                }
            }
        }
    }
    long long ans = 0;
    for (int mask = 0; mask < 1 << n; mask++) {
        ans += dp[n - 1][mask][k];
    }
    cout << ans << "\n";
}