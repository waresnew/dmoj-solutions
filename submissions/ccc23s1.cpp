#include <bits/stdc++.h>

// 9/12/2023
using namespace std;
int c, a[5][200003];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin >> c;
    for (int i = 1; i <= 2; ++i) {
        for (int j = 1; j <= c; ++j) {
            cin >> a[i][j];
        }
    }
    int ans = 0;
    for (int i = 1; i <= 2; ++i) {
        for (int j = 1; j <= c; ++j) {
            ans += max(0,3*a[i][j]-a[i][j+1]-a[i][j-1]);
            if (j%2!=0&&a[i][j]) {
                ans -= a[i+1][j]+a[i-1][j];
            }
        }
    }
    cout << ans << "\n";

}