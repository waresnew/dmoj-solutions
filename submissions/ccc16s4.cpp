#include <bits/stdc++.h>

// 5/3/2023
using namespace std;
bool dp[403][403];
int psa[403];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> psa[i];
        psa[i] += psa[i - 1];
        dp[i][i] = true;
    }
    for (int l = 2; l <= n; l++) {
        for (int i = 1, j = i + l - 1; j <= n; i++, j++) {
            for (int p = i, q = j; p < q;) {
                dp[i][j] |= dp[p+1][q-1] && dp[i][p] && dp[q][j] && psa[j] - psa[q - 1] == psa[p] - psa[i - 1];
                if (psa[j]-psa[q-1]<psa[p]-psa[i-1]) {
                    q--;
                } else {
                    p++;
                }
            }
            for (int m = i; m < j; m++) {
                dp[i][j] |= dp[i][m] && dp[m + 1][j] && psa[m] - psa[i - 1] == psa[j] - psa[m];
            }
        }
    }
    int ans = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (dp[i][j]) {
                ans = max(ans, psa[j] - psa[i - 1]);
            }
        }
    }
    cout << ans << "\n";

}