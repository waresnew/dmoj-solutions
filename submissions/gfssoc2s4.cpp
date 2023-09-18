#include <bits/stdc++.h>
using namespace std;
vector<pair<long long, int>> graph[500001], rev[500001];
long long dis[500001], rev_dis[500001];
void dijkstra(int start, vector<pair<long long, int>> graph[], long long dis[]) {
    fill(dis, dis+500001, 1e18);
    priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> queue;
    queue.push({0,start});
    dis[start]=0;
    while (!queue.empty()) {
        auto [_, cur] = queue.top(); queue.pop();
        for (auto& [weight, next] : graph[cur]) {
            if (dis[next]>dis[cur]+weight) {
                dis[next]=dis[cur]+weight;
                queue.push({dis[next], next});
            }
        }
    }
}
int main() {
    cin.sync_with_stdio(0); cin.tie(0);
    int n,m;cin>>n>>m;
    for (int i = 0; i < m; ++i) {
        int a,b,k;cin>>a>>b>>k;
        graph[a].push_back({k, b});
        rev[b].push_back({k,a});
    }
    dijkstra(1,graph, dis); dijkstra(n, rev, rev_dis);
    int d;cin>>d;
    long long ans = dis[n];
    for (int i = 0; i < d; ++i) {
        int a,b,g;cin>>a>>b>>g;
        ans = min(dis[a]+rev_dis[b]+g, ans);
    }
    cout << (ans==1e18?-1:ans)<<"\n";


}