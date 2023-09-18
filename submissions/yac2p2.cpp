#include <bits/stdc++.h>

// 5/28/2023
using namespace std;
int n, pxor[100003];

int ask(int l, int r) {
    cout << "? " << l << " " << r << endl;
    int x;
    cin >> x;
    return x;
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    pxor[n] = ask(1, n);
    for (int i = 1; i < n; i++) {
        if (i <= n / 2) { //bc minimize M to n/2
            pxor[i] = ask(i + 1, n) ^ pxor[n];
        } else {
            pxor[i] = ask(1, i);
        }
    }
    cout << "! ";
    for (int i = 1; i <= n; i++) {
        cout << (pxor[i] ^ pxor[i - 1]) << " \n"[i == n];
    }
}