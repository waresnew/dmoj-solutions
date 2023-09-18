#include <bits/stdc++.h>

// 2/14/2023
using namespace std;
bool cat[26][26];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int r,c,k;cin>>r>>c>>k;
    for (int i = 0; i < k; ++i) {
        int x,y;cin>>x>>y;
        cat[x][y]=true;
    }
    int dp[r+1][c+1];
    for (int i = 1; i <= r; ++i) {
        for (int j = 1; j <= c; ++j) {
            dp[i][j]=0;
        }
    }
    dp[1][1]=1;
    for (int i = 1; i <= r; i++) {
        for (int j = 1; j <= c; j++) {
            if (i+1<=r&&!cat[i+1][j]) {
                dp[i+1][j]+=dp[i][j];
            }
            if (j+1<=c&&!cat[i][j+1]) {
                dp[i][j+1]+=dp[i][j];
            }
        }
    }
    cout << dp[r][c];
}