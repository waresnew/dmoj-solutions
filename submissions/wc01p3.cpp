#include <bits/stdc++.h>

// 5/1/2023
using namespace std;
int T;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    for (cin >> T; T > 0; T--) {
        int x;
        cin >> x;
        string str = "";
        while (x > 0) {
            str += x % 2 + '0';
            x /= 2;
        }
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            ans += (str[i]-'0') << (str.length()-i-1);
        }
        cout << ans << "\n";
    }
}