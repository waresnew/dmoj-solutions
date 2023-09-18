#include <bits/stdc++.h>

// 2/13/2023
using namespace std;
typedef pair<int,int> pii;
pii cages[1001];
int dp[1001];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int c,m;cin>>c>>m;
    for (int i = 1; i <= c; i++) {
        int n,k;cin>>n>>k;
        cages[i]=pii(n,k);
    }
    for (int i = 1; i <= c; i++) {
        for (int j = m; j >=cages[i].second; j--) {
            dp[j]=max(dp[j], dp[j-cages[i].second]+cages[i].first);
        }
    }
    cout << dp[m] << "\n";
}