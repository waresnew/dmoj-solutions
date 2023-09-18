#include <bits/stdc++.h>

// 2/8/2023
using namespace std;
pair<int,int> problems[1001];
int dp[1001][1001]; //[limit][max_hours]
int solve(int cur, int weight) {
    if (cur==0 || weight==0) {
        return dp[cur][weight]=0;
    }
    if (dp[cur][weight]!=INT_MIN) return dp[cur][weight];
    auto [value, cost] = problems[cur];
    if (cost>weight) {
        return dp[cur][weight]=solve(cur-1, weight);
    }
    return dp[cur][weight]=max(value+solve(cur-1,weight-cost), solve(cur-1,weight));
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n,t;
    cin>>n>>t;
    for (int i = 0; i < 1001; ++i) {
        for (int j = 0; j < 1001; ++j) {
            dp[i][j]=INT_MIN;
        }
    }
    for (int i = 1; i <= n; ++i) {
        int a,b;cin>>a>>b;
        problems[i]=pair(a,b);
    }
    cout << solve(n,t) << "\n";
}