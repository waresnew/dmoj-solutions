#include <bits/stdc++.h>

// 6/11/2023
using namespace std;
int dp[100003];
int mod = 1e9+7;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    dp[0]=1;
    dp[1] = 2;
    int n, k;
    cin >> n >> k;
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1]%mod; //add a c
        if (i>=k+1) {
            dp[i] =(dp[i]+ dp[i - k - 1])%mod; //add a d bc i can take dp[i-k-1], add k c's, and then add a d for each of them
        } else {
            dp[i]=(dp[i]+1)%mod; //account for adding 1 d to chain of c
        }
    }
    cout << dp[n] << "\n";
}