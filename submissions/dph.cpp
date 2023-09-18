#include <bits/stdc++.h>

// 4/9/2023
using namespace std;
int h, w;
char grid[1000][1000];
int dp[1000][1000];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin >> h >> w;
    for (int i = 0; i < h; ++i) {
        for (int j = 0; j < w; ++j) {
            cin >> grid[i][j];
        }
    }
    dp[0][0] = 1;
    for (int i = 0; i < h; ++i) {
        for (int j = 0; j < w; ++j) {
            if (i == 0 && j == 0) {
                continue;
            }
            if (grid[i][j] == '.'&&i==0) {
                 dp[i][j] = (dp[i][j - 1]) % (int) (1e9 + 7);
                 continue;
            }
            if (grid[i][j] == '.'&&j == 0) {
             dp[i][j]=(dp[i-1][j])   % (int) (1e9 + 7);
             continue;
            }
            if (grid[i][j] == '.') {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % (int) (1e9 + 7);
            }
        }
    }
    cout << dp[h - 1][w - 1] << "\n";
}