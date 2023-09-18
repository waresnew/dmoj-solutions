#include <bits/stdc++.h>

// 4/18/2023
using namespace std;
int n;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>n;
    long long alice = 0, duke = 0;
    for (int i = 0; i < n; i++) {
        int a;cin>>a;
        if (a%2==0) {
            duke += ceil(a/2.0);
        } else {
            alice += ceil(a/2.0);
        }
    }
    cout << (alice>=duke?"Alice\n":"Duke\n");
}