#include <bits/stdc++.h>

// 5/13/2023
using namespace std;
typedef array<int, 3> Part;
int dp[3003][32]; //bitmask dp[w][00000] where each bit is whether that part type has been added
Part items[1003];


int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int t, n;
    cin >> t >> n;
    for (int i = 1; i <= n; ++i) {
        int c, v, tt;
        cin >> c >> v >> tt;
        items[i] = {c, v, tt};
    }
    int budget;
    cin >> budget;
    for (int i = 0; i <= budget; i++) {
        dp[i][0] = 0;
    }
    for (int i = 1; i <= n; ++i) {
        auto [cost, value, type] = items[i];
        for (int j = budget; j >= cost; j--) {
            for (int k = 0; k < 32; k++) {
                int nextMask = 1 << (type - 1);
                int next = k | nextMask;
                int prevMask = ~(1 << (type - 1));
                int prev = k & prevMask;
                dp[j][next] = max(dp[j][next], dp[j - cost][prev] + value);
            }
        }
    }
    int ans = dp[budget][(1<<t)-1];
    cout << (ans == 0 ? -1 : ans) << "\n";
}