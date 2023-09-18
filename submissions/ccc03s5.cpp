#include <bits/stdc++.h>

using namespace std;
vector<pair<int, int>> graph[10001];
vector<int> target;
int c, r, d;

bool check(int weight) {
    queue<pair<int, int>> queue;
    queue.push(pair(1, 0));
    bool vis[10001];
    memset(vis, false, sizeof(vis));
    vis[1]=true;
    while (!queue.empty()) {
        auto cur = queue.front(); queue.pop();
        for (auto& next : graph[cur.first]) {
            if (!vis[next.first]&&next.second>=weight) {
                vis[next.first]=true;
                queue.push(next);
            }
        }
    }
    for (int t : target) {
        if (!vis[t]) {
            return false;
        }
    }
    return true;
}

int main() {
    cin >> c >> r >> d;
    for (int i = 0; i < r; ++i) {
        int x, y, w;
        cin >> x >> y >> w;
        graph[x].push_back(pair(y, w));
        graph[y].push_back(pair(x, w));
    }
    for (int i = 0; i < d; ++i) {
        int t;
        cin >> t;
        target.push_back(t);
    }
    int low=0,high=100000,ans = 0;
    while (low<=high) {
        int mid=(low+high)/2;
        if (check(mid)) {
            low = mid+1;
            ans = mid;
        } else {
            high = mid-1;
        }
    }
    cout << ans << "\n";
}