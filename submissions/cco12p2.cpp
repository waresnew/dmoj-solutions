#include <bits/stdc++.h>
using namespace std;
struct Edge {
    int val, weight;

    Edge(int val, int weight) : val(val), weight(weight) {}

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
struct FullEdge {
    int from,to,weight;

    FullEdge(int from, int to, int weight) : from(from), to(to), weight(weight) {}
};
int n,m;
void dijk(int start, vector<Edge> graph[], int dis[]) {
    priority_queue<Edge, vector<Edge>, greater<Edge>> queue;
    queue.push(Edge(start,0));
    fill(dis, dis+n+1, 1e9);
    dis[start]=0;
    while (!queue.empty()) {
        auto cur = queue.top(); queue.pop();
        for (auto& next : graph[cur.val]) {
            if (dis[cur.val]+next.weight<dis[next.val]) {
                dis[next.val]=dis[cur.val]+next.weight;
                queue.push(Edge(next.val, dis[cur.val]+next.weight));
            }
        }
    }
}
int dis[20001], rev_dis[20001];
vector<Edge> graph[20001], rev_graph[20001];
vector<FullEdge> edges;
int main() {
    cin.sync_with_stdio(0); cin.tie(0);
    cin>>n>>m;
    for (int i = 0; i < m; ++i) {
        int a,b,l;cin>>a>>b>>l;
        edges.push_back(FullEdge(a,b,l));
        graph[a].push_back(Edge(b,l));
        rev_graph[b].push_back(Edge(a,l));
    }
    dijk(1,graph, dis); dijk(n,rev_graph,rev_dis);
    if (dis[n]==1e9) {
        cout << "-1\n";
        return 0;
    }
    int ans = 1e9;
        for (FullEdge edge : edges) {
            int new_dis=dis[edge.from]+edge.weight+rev_dis[edge.to];
            if (new_dis>dis[n]&&new_dis<ans) {
                ans = new_dis;
            }
        }
    cout << (ans==1e9?-1:ans)<<"\n";
}