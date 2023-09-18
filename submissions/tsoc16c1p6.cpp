#include <bits/stdc++.h>

// 3/25/2023
using namespace std;
int dp[1001][1001];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n, m;
    cin >> n >> m;
    string a, b;
    cin >> a >> b;
    for (int i = 0; i <= n; ++i) {
        for (int j = 0; j <= m; ++j) {
            if (i == 0) {
                dp[i][j] = (j+2)/3;
            } else if (j == 0) {
                dp[i][j] = (i+2)/3;
            } else {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j] + 1, min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                    if (i >= 3) {
                        dp[i][j] = min(dp[i - 3][j] + 1, dp[i][j]);
                    }
                    if (j >= 3) {
                        dp[i][j] = min(dp[i][j - 3] + 1, dp[i][j]);
                    }
                    if (i >= 2) {
                        dp[i][j] = min(dp[i - 2][j] + 1, dp[i][j]);
                    }
                    if (j >= 2) {
                        dp[i][j] = min(dp[i][j - 2] + 1, dp[i][j]);
                    }
                }
            }
        }
    }
    cout << dp[n][m] << "\n";
}