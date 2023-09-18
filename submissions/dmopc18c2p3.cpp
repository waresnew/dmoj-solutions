#include <bits/stdc++.h>

// 2/2/2023
using namespace std;
int gifts[100001];
vector<int> graph[100001];
int end_dis[100001], begin_dis[100001];
void bfs(int dis[], int start) {
    queue<int> queue;
    queue.push(start);
    while (!queue.empty()) {
        auto cur = queue.front(); queue.pop();
        for (int next : graph[cur]) {
            if (dis[next]==0&&next!=start) {
                dis[next]=dis[cur]+1;
                queue.push(next);
            }
        }
    }
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n,m,k,start,end;cin>>n>>m>>k>>start>>end;
    for (int i = 0; i < k; ++i) {
        cin>>gifts[i];
    }
    for (int i = 0; i < m; ++i) {
        int a,b;cin>>a>>b;
        graph[a].push_back(b); graph[b].push_back(a);
    }
    bfs(end_dis, end);
    bfs(begin_dis, start);
    int ans = INT_MAX;
    for (int i = 0; i < k; ++i) {
        ans = min(ans, begin_dis[gifts[i]]+end_dis[gifts[i]]);
    }
    cout << ans << "\n";
}