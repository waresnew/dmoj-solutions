#include <bits/stdc++.h>

// 3/25/2023
using namespace std;
struct Location {
    int first = INT_MAX, second=INT_MIN;
};
map<int, Location> indexes;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < n; ++i) {
        int c;
        cin >> c;
        indexes[c].first = min(indexes[c].first, i);
        indexes[c].second = max(indexes[c].second, i);
    }
    int ans = 0;
    for (int i = 0; i < m; ++i) {
        int a,b;cin>>a>>b;
        if (indexes[a].first==INT_MAX||indexes[b].second==INT_MIN) continue;
        ans = max(indexes[b].second-indexes[a].first+1, ans);
    }
    cout << ans << "\n";
}