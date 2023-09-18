#include <bits/stdc++.h>

// 2/13/2023
using namespace std;
typedef array<int, 3> day;
int dp[100001][3];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    day days[n + 1];
    for (int i = 1; i <= n; ++i) {
        int a, b, c;
        cin >> a >> b >> c;
        days[i] = {a, b, c};
    }
    for (int i = 1; i <= n; i++) {
        dp[i][0]=max(dp[i - 1][2] + days[i][0], dp[i - 1][1] + days[i][0]);
        dp[i][1]=max(dp[i - 1][2] + days[i][1],dp[i - 1][0] + days[i][1]);
        dp[i][2]=max(dp[i - 1][1] + days[i][2], dp[i - 1][0] + days[i][2]);
    }
    cout << max(dp[n][2], max(dp[n][0], dp[n][1])) << "\n";
}