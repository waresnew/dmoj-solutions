#include <bits/stdc++.h>

// 12/7/2022
using namespace std;
int grid[1001][1001];
bool cow[1001][1001];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    int ans = 0;
    for (int i = 0; i < n; ++i) {
        int x, y;
        cin >> x >> y;
        cow[x][y]=true;
        pair<int, int> nexts[] = {
                pair(x + 1, y),
                pair(x, y + 1),
                pair(x - 1, y),
                pair(x, y - 1)
        };
        for (auto& next: nexts) {
            if (next.first<1001&&next.second<1001&&next.first>=0&&next.second>=0) {
                grid[next.first][next.second]++;
                if (!cow[next.first][next.second]) {
                    continue;
                }
                if (grid[next.first][next.second]==3) {
                    ans++;
                } else if (grid[next.first][next.second]==4) {
                    ans--;
                }
            }
        }
        cout << ans << "\n";
    }
}