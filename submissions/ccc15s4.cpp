#include <bits/stdc++.h>
using namespace std;
struct Edge {
    int val,weight,hull;

    Edge(int val, int weight, int hull) : val(val), weight(weight), hull(hull) {
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
vector<Edge> graph[2001];
int dis[2001][201];
int main() {
    memset(dis, 0x3f, sizeof(dis));
    cin.sync_with_stdio(0); cin.tie(0);
    int hull_max,n,m;cin>>hull_max>>n>>m;

    for (int i = 0; i < m; ++i) {
        int a,b,t,h;cin>>a>>b>>t>>h;
        graph[a].push_back(Edge(b, t, h));
        graph[b].push_back(Edge(a, t, h));
    }
    int start, end;cin>>start>>end;
    priority_queue<Edge, vector<Edge>, greater<Edge>> queue;
    dis[start][0]=0;
    queue.push(Edge(start,0,0));
    while (!queue.empty()) {
        auto cur = queue.top(); queue.pop();
        if (cur.val==end) {
            cout << cur.weight<<"\n";
            return 0;
        }
        for (auto& next : graph[cur.val]) {
            int next_hull=next.hull+cur.hull;
            if (next_hull<hull_max && dis[cur.val][cur.hull]+next.weight<dis[next.val][next_hull]) {
                dis[next.val][next_hull]=dis[cur.val][cur.hull]+next.weight;
                queue.push(Edge(next.val, dis[cur.val][cur.hull]+next.weight, next_hull));
            }
        }
    }
    cout << "-1\n";
}