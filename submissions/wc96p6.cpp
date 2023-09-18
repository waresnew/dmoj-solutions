#include <bits/stdc++.h>

// 4/24/2023
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    for (int T = 0; T < 5; T++) {
        string a, b;
        int a_b, b_b, target;
        cin >> a >> a_b >> b >> b_b >> target;
        int a10 = 0, b10 = 0;
        for (int i = 0; i < a.length(); i++) {
            a10 += (a[i] - '0') * pow(a_b, a.length() - i - 1);
        }
        for (int i = 0; i < b.length(); i++) {
            b10 += (b[i] - '0') * pow(b_b, b.length() - i - 1);
        }
        int product = a10 * b10;
        string ans = "";
        while (product > 0) {
            ans += '0' + product % target;
            product /= target;
        }
        reverse(ans.begin(), ans.end());
        cout << ans << "\n";
    }
}