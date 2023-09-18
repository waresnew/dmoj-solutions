#include <bits/stdc++.h>
using namespace std;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int a, b;
    cin >> a >> b;
    int ans = 2;
    while (true) {
        int cur = a-b;
        if (cur<0) {
            break;
        }
        a=b;
        b = cur;
        ans++;
    }
    cout << ans << "\n";
}