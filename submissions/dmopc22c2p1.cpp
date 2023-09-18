#include <bits/stdc++.h>
using namespace std;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    bool alive[n+1];

    int ans = 0;
    fill(alive, alive+n+1, true);
    for (int i = 1; i <= n; ++i) {
        if ((i==1?alive[n]:alive[i-1])&&(i==n?alive[1]:alive[i+1])) {
            if (i == n) {
                alive[1]=false;
                ans++;
            } else {
                alive[i + 1] = false;
                ans++;
            }
        }
    }
    cout << n-ans << "\n";
    for (int i = 1; i <= n; i++) {
        cout << (alive[i]?"M":"_");
    }
    cout << "\n";
}