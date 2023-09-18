#include<bits/stdc++.h>

using namespace std;
vector<int> out_graph[300001], in_graph[300001];
bool vis[300001];
int ans[300001];

void dfs(int cur, int i) {
    for (int next: in_graph[cur]) {
        if (!vis[next]) {
            vis[next] = true;
            if (next < i) {
                ans[next] = i;
            }
            dfs(next, i);
        }
    }
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < m; ++i) {
        int a, b;
        cin >> a >> b;
        in_graph[b].push_back(a);
        out_graph[a].push_back(b);
    }

    for (int i = n; i >= 1; i--) {
        dfs(i, i);
    }
    for (int i = n; i >= 1; i--) {
        if (ans[i] > i) {
            cout << i << " " << ans[i] << "\n";
            return 0;
        }
    }
    cout << "-1\n";

}