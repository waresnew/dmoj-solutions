#include <bits/stdc++.h>

// 11/30/2022
using namespace std;
struct Edge {
    int val, weight;

    Edge(int val, int weight) {
        this->val = val;
        this->weight = weight;
    }
};

vector<Edge> tree[200001];

void bfs(int dis[], int start) {
    queue<int> queue;
    queue.push(start);
    while (!queue.empty()) {
        int cur = queue.front();
        queue.pop();
        for (Edge &next: tree[cur]) {
            if (dis[next.val] == 0 && next.val != start) {
                dis[next.val] = dis[cur] + next.weight;
                queue.push(next.val);
            }
        }
    }
}
int dis[200001];

int dis2[200001];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n, t;
    int edge_total=0;
    cin >> n >> t;
    for (int i = 0; i < n - 1; ++i) {
        int a, b, c;
        cin >> a >> b >> c;
        edge_total+=c;
        tree[a].push_back(Edge(b, c));
        tree[b].push_back(Edge(a, c));
    }
    int diameter1 = 0;
    bfs(dis,1);
    for (int i = 1; i <= n; ++i) {
        if (dis[i]>dis[diameter1]) {
            diameter1=i;
        }
    }
    fill(begin(dis),end(dis), 0);
    int diameter2 = 0;
    bfs(dis, diameter1);
    for (int i = 1; i <= n; ++i) {
        if (dis[i]>dis[diameter2]) {
            diameter2=i;
        }
    }
    bfs(dis2, diameter2);

    for (int i = 1; i <= n; ++i) {
        if (tree[i].size()==t) {
            cout << i << " " << 2*edge_total-max(dis2[i], dis[i]) << "\n";
        }
    }
}