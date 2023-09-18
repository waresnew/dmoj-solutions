#include <bits/stdc++.h>

// 2/8/2023
using namespace std;
typedef pair<int,int> pii;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n,w;cin>>n>>w;
    pii items[n+1];
    for (int i = 1; i <= n; i++) {
        int w1,v;cin>>w1>>v;
        items[i]=pii(w1,v);
    }
    int dp[1000*n+1];
    fill(dp, dp+1000*n+1, 1e9+1);
    dp[0]=0;
    for (int i = 1; i <= n; i++) {
        for (int j = 1000*n; j >=items[i].second ; --j) {
            dp[j]=min(dp[j], dp[j-items[i].second]+items[i].first);
        }
    }
    for (int i = 1000*n;i>=0;i--) {
        if (dp[i]<=w) {
            cout << i << "\n"; break;
        }
    }


}