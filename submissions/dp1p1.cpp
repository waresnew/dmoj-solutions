#include <bits/stdc++.h>

// 2/8/2023
using namespace std;
int a[100001];
int dp[100001][2];
int solve(int i, bool include) {
    if (i==0) {
        return 0;
    }
    if (dp[i][1]&&include) return dp[i][1];
    if (dp[i][0]&&!include) return dp[i][0];
    int ans1 = solve(i-1, true), ans2=solve(i-1, false)+a[i];
   if (!include) {
       return dp[i][0]=max(dp[i][0], ans1);
   }
   return dp[i][1]=max(ans1,ans2);
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;cin>>n;
    for (int i = 1; i <= n; ++i) {
        cin>>a[i];
    }
    cout << solve(n,true) << "\n";
}