#include <bits/stdc++.h>

// 2/8/2023
using namespace std;
int dp[100001];
int frogs[100001];
int n;
int solve(int cur) {
    if (cur==1) {
        return dp[cur]=0;
    }
    if (dp[cur]!=INT_MAX) return dp[cur];
    if (cur==2) {
        return dp[cur]=min(dp[cur], solve(cur-1)+abs(frogs[cur]-frogs[cur-1]));
    }
    int ans1 = solve(cur-1)+abs(frogs[cur]-frogs[cur-1]);
    int ans2 = solve(cur-2)+abs(frogs[cur]-frogs[cur-2]);
        return dp[cur]=min(dp[cur], min(ans1, ans2));

}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    fill(dp,dp+100001, INT_MAX);
    cin>>n;
    for (int i = 1; i <= n; ++i) {
        cin>>frogs[i];
    }
    cout << solve(n) << "\n";
}