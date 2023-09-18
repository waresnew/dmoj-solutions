#include <bits/stdc++.h>

// 12/12/2022
using namespace std;

int letter_to_num(char c) {
    return c - 'A' + 10;
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    char grid[n][n];
    for (int i = 0; i < n; ++i) {
        string input;
        cin >> input;
        for (int j = 0; j < n; ++j) {
            grid[i][j] = input[j];
        }
    }
    for (int i = 0; i < n; ++i) {
        bool vis[n];
        memset(vis,false,sizeof(vis));
        for (int j = 0; j < n; ++j) {
            int num = isdigit(grid[i][j]) ? grid[i][j] - '0' : grid[i][j] - 'A' + 10;
            if (vis[num]) {
                cout << "No\n";
                return 0;
            }
            vis[num] = true;
        }
    }
    for (int i = 0; i < n; ++i) {
        bool vis[n];
        memset(vis,false,sizeof(vis));
        for (int j = 0; j < n; ++j) {
            int num = isdigit(grid[j][i]) ? grid[j][i] - '0' : grid[j][i] - 'A' + 10;
            if (vis[num]) {
                cout << "No\n";
                return 0;
            }
            vis[num] = true;
        }
    }
    int cur1=-1, cur2=-1;
    for (int i = 0; i < n; i++) {
        if (grid[0][i] < cur1||grid[i][0]<cur2) {
            cout << "Latin\n";
            return 0;
        }
        cur1=grid[0][i];
        cur2=grid[i][0];
    }
    cout << "Reduced\n";
}