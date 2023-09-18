#include <bits/stdc++.h>

// 5/1/2023
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    string n;
    cin >> n;
    long long num = stoll(n);
    string bin = "";
    while (num > 0) {
        bin += '0' + num % 2;
        num /= 2;
    }
    string ans = "";
    for (int i = 0; i < bin.length(); i++) ans += "1";
    cout << ans << "\n";
}