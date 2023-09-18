#include <bits/stdc++.h>

// 4/22/2023
using namespace std;
int dp[203][203];
int a[203];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    while (true) {
        int n;
        cin >> n;
        if (n == 0) {
            break;
        }
        for (int i = 1; i <= n; i++) {
            cin >> a[i];
        }
        for (int l = 3; l <= n; l++) {
            for (int i = 1, j = i + l - 1; j <= n; i++, j++) {
                if (l == 3) {
                    dp[i][j] = a[i] + a[i + 1] + a[i + 2];
                    continue;
                }
                for (int m = i + 1; m <= j - 1; m++) {
                    dp[i][j] = max(dp[i][j], a[i] + a[m] + a[j] + dp[i][m] + dp[m][j]);
                }
            }
        }
        cout << dp[1][n] << "\n";
        memset(dp, 0, sizeof(dp));
        memset(a, 0, sizeof(a));
    }
}