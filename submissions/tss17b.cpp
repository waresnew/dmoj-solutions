#include <bits/stdc++.h>

using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n, q;
    cin >> n >> q;
    double houses[n];
    for (int i = 0; i < n; ++i) {
        double x, y;
        cin >> x >> y;
        houses[i] = sqrt(x * x + y * y);
    }
    sort(houses, houses + n);
    for (int i = 0; i < q; ++i) {
        int r;
        cin >> r;
        int low = 0, high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (houses[mid] <= r) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        cout << ans+1<<"\n";
    }
}