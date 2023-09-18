#include <bits/stdc++.h>

// 3/25/2023
using namespace std;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n,k;cin>>n>>k;
    for (int i = 0; i < k; ++i) {
        int s,t,r;cin>>s>>t>>r;
        int ans = 0;
        int hours = 0;
        int prob = 0;
        for (int j = 1; j <= n; j++) {
            prob++;
            if (hours >= t) {
                ans+=r;
                hours=0;
            }
            if (j%s==0) {
                ans++;
                hours++;
                prob=0;
            }
        }
        if (prob!=0) ans++;
        cout << ans << "\n";
    }
}