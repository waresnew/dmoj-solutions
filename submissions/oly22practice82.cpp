#include <bits/stdc++.h>

// 12/18/2022
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    string a, b;
    cin >> a >> b;
    int diff[a.length() - 1];
    memset(diff, 0, sizeof(diff));
    for (int i = 1; i < a.length(); ++i) {
        int count = 0;
        char cur = a[i - 1];
        while (true) {
            if (cur != a[i]) {
                if (cur == 'z') {
                    cur = 'a';
                } else {
                    cur++;
                }
                count++;
            } else {
                break;
            }

        }
        diff[i-1] = count;
    }
    for (int i = 1; i < b.length(); i++) {
        char cur = b[i - 1];
        int count = 0;
        while (true) {
            if (cur != b[i]) {
                if (cur == 'z') {
                    cur = 'a';
                } else {
                    cur++;
                }
                count++;
            } else {
                break;
            }
        }
        if (diff[i-1] != count) {
            cout << "No\n";
            return 0;
        }
    }
    cout << "Yes\n";
}