#include <bits/stdc++.h>

// 4/18/2023
using namespace std;
int pgcd[200002], sgcd[200002], a[200002];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;cin>>n;
    for (int i = 1; i <= n; ++i) {
        cin>>a[i];
    }
    for (int i = 1; i <= n; i++) {
        pgcd[i]=gcd(pgcd[i-1], a[i]);
        sgcd[n-i+1]=gcd(sgcd[n-i+2], a[n-i+1]);
    }
    int ans = 1;
    for (int i = 1; i <= n; i++) {
        ans = max(ans, gcd(pgcd[i-1], sgcd[i+1]));
    }
    cout << ans << "\n";



}