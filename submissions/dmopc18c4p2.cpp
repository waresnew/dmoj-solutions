#include <bits/stdc++.h>

// 3/8/2023
using namespace std;

int tasks[701];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int sum = 0;
    int n;cin>>n;
    for (int i = 1; i <= n; i++) { cin >> tasks[i];sum += tasks[i]; }
    bool dp[sum/2+1]; memset(dp, 0, sizeof(dp));
    dp[0]=true;
    for (int i = 1; i <= n; i++) {
        for (int j = sum/2; j>=tasks[i]; j--) {
            if (dp[j-tasks[i]]) {
                dp[j]=true;
            }
        }
    }
    for (int i = sum/2; i >=0; i--) {
        if (dp[i]) {
            cout << abs(i-(sum-i))<<"\n"; return 0;
        }
    }
}