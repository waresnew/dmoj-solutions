#include <bits/stdc++.h>

// 1/31/2023
using namespace std;
int planes[100000];
set<int> gates;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int g,p;cin>>g>>p;
    for (int i = 0; i < p; ++i) {
        cin>>planes[i];
    }
    for (int i = 1; i <= g; i++) gates.insert(i);
    int ans = 0;
    for (int plane : planes) {
        if (gates.find(plane)!=gates.end()) {
            gates.erase(plane);
            ans++;
        } else {
            auto next = gates.upper_bound(plane);
            if (next!=gates.begin()) {
                gates.erase(--next);
                ans++;
            } else {
                break;
            }
        }
    }
    cout << ans << "\n";
}