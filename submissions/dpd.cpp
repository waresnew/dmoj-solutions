#include <bits/stdc++.h>
using namespace std;
typedef pair<int,int> pii;
long long dp[100001];
pii a[101];
int main() {
    int n,w;cin>>n>>w;
    for (int i = 1; i <= n; i++){
        int _a,b;cin>>_a>>b;
        a[i]=pii(_a,b);
    }
    for (int i = 1; i <= n; ++i) {
        for (long long j = w; j >= a[i].first; j--) {
            dp[j]=max(dp[j], dp[j-a[i].first]+a[i].second);
        }
    }
    cout << dp[w]<<"\n";


}