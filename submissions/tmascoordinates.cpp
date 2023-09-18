#include <bits/stdc++.h>

// 12/18/2022
using namespace std;
vector<pair<int,int>> graph[100001];
void bfs(int dis[], int start) {
    queue<pair<int,int>> queue;
    queue.push(pair(start,0));
    while (!queue.empty()) {
        auto cur = queue.front(); queue.pop();
        for (auto& next : graph[cur.first]) {
            if (dis[next.first]==0&&next.first!=start) {
                dis[next.first]=dis[cur.first]+next.second;
                queue.push(next);
            }
        }
    }
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n,q;cin>>n>>q;
    for (int i = 0; i < n-1;i++) {
        int a,b,c;cin>>a>>b>>c;
        graph[a].push_back(pair(b,c));
        graph[b].push_back(pair(a,c));
    }
    int dis[n+1];
    memset(dis,0,sizeof(dis));
    bfs(dis,1);
    int diameter1 = 1;
    for (int i = 1; i <=n ; ++i) {
        if (dis[i]>dis[diameter1]) {
            diameter1=i;
        }
    }
    memset(dis,0,sizeof(dis));
    bfs(dis,diameter1);
    int diameter2=1;
    for (int i = 1; i <=n ; ++i) {
        if (dis[i]>dis[diameter2]) {
            diameter2=i;
        }
    }
    int dis2[n+1];
    memset(dis2,0,sizeof(dis2));
    bfs(dis2, diameter2);
    for (int i = 0; i < q; ++i) {
        int x;cin>>x;
        cout << max(dis[x], dis2[x]) <<"\n";
    }
}