#include <bits/stdc++.h>
using namespace std;
vector<int> motels;
int min_dis,max_dis;

int main() {
    cin.sync_with_stdio(0); cin.tie(0);
    int n;cin>>min_dis>>max_dis>>n;
    int start[]= {0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000};
    for (int i : start) motels.push_back(i);
    for (int i = 0; i < n; ++i) {
        int m;cin>>m;motels.push_back(m);
    }
    sort(motels.begin(), motels.end());
    long long dp[motels.size()];
    fill(dp, dp+motels.size(),0);
    dp[0]=1;
    for (int i = 1; i < motels.size(); i++) {
        for (int j = i-1; j >=0; j--) {
            int dis = motels[i]-motels[j];
            if (dis>=min_dis&&dis<=max_dis) {
                dp[i] += dp[j];
            }
        }
    }

    cout << dp[motels.size()-1] << "\n";
}