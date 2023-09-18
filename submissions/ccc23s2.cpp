#include <bits/stdc++.h>

// 9/12/2023
using namespace std;
int n, mountains[5003], dp[5003][5003], ans[5003];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> mountains[i];
    }
    for (int i = 0; i < n; ++i) {
        for (int offset = 1; offset <= min(n - i - 1, i); ++offset) {
            dp[i - offset][i + offset] = dp[i - offset + 1][i + offset - 1] + abs(mountains[i - offset] - mountains[i + offset]);
        }
        for (int a = i, b = i + 1; a >= 0 && b < n; a--, b++) {
            dp[a][b]=dp[a+1][b-1]+abs(mountains[a]-mountains[b]);
        }

    }
    fill(ans, ans + n + 1, 1e9);
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            if (i > j) continue;
            ans[j - i + 1] = min(ans[j - i + 1], dp[i][j]);
        }
    }
    for (int i = 1; i <= n; ++i) {
        cout << ans[i] << " \n"[i == n];
    }
}