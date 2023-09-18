#include <bits/stdc++.h>

// 1/24/2023
using namespace std;
struct Edge {
    int val, weight;

    Edge(int val, int weight) : val(val), weight(weight) {}

    bool operator<(const Edge& rhs) const {
        if (val < rhs.val)
            return true;
        if (rhs.val < val)
            return false;
        return weight < rhs.weight;
    }

    bool operator>(const Edge& rhs) const {
        return rhs < *this;
    }

    bool operator<=(const Edge& rhs) const {
        return !(rhs < *this);
    }

    bool operator>=(const Edge& rhs) const {
        return !(*this < rhs);
    }
};
vector<Edge> graph[2001];
bool grocery[2001];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int max_dis;cin>>max_dis;
    int n,m,g;cin>>n>>m>>g;
    for (int i = 0; i < g; ++i) {
        int building;cin>>building;
        grocery[building]=true;
    }
    for (int i = 0; i < m; ++i) {
        int a,b,l;cin>>a>>b>>l;
        graph[a].push_back(Edge(b,l));
    }
    int dis[n+1];
    for (int i = 1; i <=n ; ++i) {
        dis[i]=INT_MAX;
    }
    dis[0]=0;
    priority_queue<Edge> queue;
    queue.push(Edge(0,0));
    while (!queue.empty()) {
        Edge cur = queue.top(); queue.pop();
        for (auto& next : graph[cur.val]) {
            if (dis[cur.val]+next.weight<dis[next.val]) {
                dis[next.val]=dis[cur.val]+next.weight;
                queue.push(next);
            }
        }
    }
    int ans = 0;
    for (int i = 1; i <=n ; ++i) {
        if (grocery[i]&&dis[i]<max_dis) {
            ans++;
        }
    }
    cout << ans << "\n";
}