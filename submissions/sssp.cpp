#include <bits/stdc++.h>

// 1/24/2023
using namespace std;

struct Edge {
    int val, weight;
    Edge(int val, int weight) {
        this->val=val; this->weight=weight;
    }

    bool operator<(const Edge& rhs) const {
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
vector<Edge> graph[1001];
int main() {
    cin.sync_with_stdio(0); cin.tie(0);
    int n,m;cin>>n>>m;
    int dis[n+1];
    for (int i = 1; i <=n ; ++i) {
        dis[i]=INT_MAX;
    }
    dis[1]=0;
    queue<Edge> queue;
    for (int i = 0; i < m; ++i) {
        int a,b,c;cin>>a>>b>>c;
        graph[a].push_back(Edge(b, c));
        graph[b].push_back(Edge(a,c));
    }
    queue.push(Edge(1,0));
    while (!queue.empty()) {
        Edge cur = queue.front(); queue.pop();
        for (auto& next : graph[cur.val]) {
            if (dis[cur.val]+next.weight<dis[next.val]) {
                dis[next.val]=dis[cur.val]+next.weight;
                queue.push(next);
            }
        }
    }
    for (int i = 1; i <= n; ++i) {
        cout << (dis[i]==INT_MAX?-1:dis[i])<<"\n";
    }
}