#include <bits/stdc++.h>

// 4/18/2023
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    for (int T = 0; T<10; T++) {
        int ans = 0;
        map<string, int> freq;
        while (true) {
            string s;
            getline(cin, s);
            if (s=="end of box") {
                break;
            }
            if (s=="red") ans+=16;
            else freq[s]++;
        }
        for (auto& [key, val] : freq) {
            ans += ceil(val/7.0)*13;
        }
        cout << ans << "\n";
    }
}