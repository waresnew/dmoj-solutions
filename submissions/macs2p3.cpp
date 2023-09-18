#include <bits/stdc++.h>

// 5/8/2023
using namespace std;
#define ll long long
ll psa[200003];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n, q;
    cin >> n >> q;
    for (int i = 1, x; i <= n; i++) {
        cin >> x;
        psa[i] = x + psa[i - 1];
    }
    //psa guaranteed to be in ascending order bc positive elements
    for (int i = 0; i < q; ++i) {
        string oi;
        cin >> oi;
        int l, s;
        cin >> l >> s;
        auto ans = lower_bound(psa + l - 1, psa + n + 1, s + psa[l - 1]);
        if (ans - psa >= n) {
            cout << n << "\n";
        } else {
            cout << ans - psa << "\n";
        }
    }
}