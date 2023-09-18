#include <bits/stdc++.h>

// 2/22/2023
using namespace std;
double dp[100001];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;cin>>n;
    int shoes[n+1];
    for (int i = 1; i <=n; ++i) {
        cin>>shoes[i];
    }
    for (int i = 0; i < 10001; ++i) {
            dp[i]=1e9;

    }
    dp[0]=0;
    for (int i = 1; i <=n;i++) {
        dp[i]=shoes[i]+dp[i-1];
        if (i>=2) {
            dp[i]= min(dp[i],dp[i-2]+min(shoes[i], shoes[i-1])*0.5+max(shoes[i], shoes[i-1]));
        }
        if (i>=3) {
            dp[i] = min(dp[i],dp[i-3]+shoes[i]+shoes[i-1]+shoes[i-2]-min(shoes[i-2],min(shoes[i], shoes[i-1])));

        }
    }
   printf("%.1f\n", dp[n]);
}