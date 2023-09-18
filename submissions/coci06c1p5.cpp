#include <bits/stdc++.h>

// 5/27/2023
using namespace std;

int n;
double dp[1 << 20];
int tasks[23][23];

double solve(int i, int mask) {
    if (i == n) {
        return dp[mask] = 1;
    }
    if (dp[mask] != -1) {
        return dp[mask];
    }
    double ans = 0;
    for (int j = 0; j < n; j++) {
        if ((mask >> j & 1) == 0) {
            ans = max(ans, tasks[i][j] / 100.0 * solve(i + 1, 1 << j | mask));
        }
    }
    return dp[mask] = ans;
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for (int i = 0; i < n; ++i) for (int j = 0; j < n; ++j) cin >> tasks[i][j];
    fill(dp, dp + (1<<20), -1);

    cout << fixed << setprecision(6) << solve(0, 0) * 100 << "\n";
}