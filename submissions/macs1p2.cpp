#include <bits/stdc++.h>
using namespace std;


int main() {
    int n;
    cin.sync_with_stdio(0); cin.tie(0);
   cin>>n;
    bool grid[2][n];
    int count = 0;
    for (int i = 0; i < 2; ++i) {
        string line; cin>>line;
        for (int j = 0; j < n; ++j) {
            grid[i][j]=line[j]=='S'?1:0;
        }
    }
    for (int i = 0; i <n; ++i) {
       if (grid[0][i] && grid[1][i]) {
           count++;
       }
    }
    cout << (count<=2?"YES\n":"NO\n");

}