#include <bits/stdc++.h>

// 6/11/2023
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;cin>>n;
    int a[n];
    for (int i = 0; i < n; ++i) {
        cin>>a[i];
    }
    int ans = a[0]>=a[1]?2:1;
    for (int l=0, r=1; r<n&&l<n;) {
        if (a[r-1]>=a[r]) {
            ans=max(ans, r-l+1);
        } else {
            l=r;
        }
        r++;
    }
    cout << ans << "\n";
}