#include <bits/stdc++.h>

// 2/14/2023
using namespace std;
typedef pair<int,int> pii;
int dp[10001];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n,max_time;
    cin >> n >> max_time;

    for (int i = 0; i < n; ++i) {
        int a_w,b_w,c_w,a_v,b_v,c_v;cin>>a_w>>a_v>>b_w>>b_v>>c_w>>c_v;
        pii options[]={
                pii(a_w, a_v),
                pii(b_w, b_v),
                pii(c_w, c_v)
        };
        int copy_dp[10001];
        copy(dp, dp+10001, copy_dp);
        for (auto& [w,v] : options) {
            for (int j = max_time; j >= w; j--) {
                dp[j]=max(dp[j], copy_dp[j-w]+v);
            }
        }
    }
    cout << dp[max_time] << "\n";
}