#include <bits/stdc++.h>

// 5/27/2023
using namespace std;
char grid[1503][1503];
char ans[1503][1503];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;cin>>n;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            cin>>grid[i][j];
            ans[i][j]='.';
        }
    }
    for (int i = 0; i < n; ++i) {
        int count = 0;
        for (int j = 0; j < n; ++j) {
            if (grid[j][i]=='S') {
                count++;
            }
        }
        for (int j = n-1; j >= n-count; j--) {
            ans[j][i] = 'S';
        }
    }
    for (int i = 0; i < n; i++) for (int j = 0; j < n;j++) cout << ans[i][j]<<(j==n-1?"\n":"");

}