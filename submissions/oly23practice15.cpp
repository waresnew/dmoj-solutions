#include <bits/stdc++.h>

// 6/11/2023
using namespace std;
typedef pair<int,int> pi;
int r, c;
bool grid[1003][1003];
bool vis[1003][1003];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin >> r >> c;
    for (int i = 1; i <= r; ++i) {
        for (int j = 1; j <= c; ++j) {
            int x;cin>>x;
            grid[i][j]=x!=0;
        }
    }
    int ans = 0;
    for (int i = 1; i <= r; ++i) {
        for (int j = 1; j <= c; ++j) {
            if (!vis[i][j]&&grid[i][j]) {
                queue<pi> queue;
                queue.push(pi(i,j));
                vis[i][j]=true;
                while (!queue.empty()) {
                    auto [x,y]=queue.front(); queue.pop();
                    for (int offset1 = -1; offset1 <= 1; offset1++) {
                        for (int offset2 = -1; offset2<=1; offset2++) {
                            if (!vis[offset1+x][offset2+y]&&grid[offset1+x][offset2+y]) {
                                vis[offset1+x][offset2+y]=true;
                                queue.push(pi(offset1+x, offset2+y));
                            }
                        }
                    }
                }
                ans++;
            }
        }
    }
    cout << ans << "\n";
}