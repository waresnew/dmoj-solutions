#include <bits/stdc++.h>

// 12/17/2022
using namespace std;
vector<int> graph[200001];
bool vis[200001];
int cycles = 0;

void find_cycles(int cur, int prev) {
    for (int next: graph[cur]) {
        if (!vis[next]) {
            vis[next] = true;
            find_cycles(next, cur);
        } else if (next != prev) {
            cycles++;
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
        graph[a].push_back(b);
        graph[b].push_back(a);
    }
    for (int i = 1; i <= n; ++i) {
        if (!vis[i]) {
            vis[i] = true;
            find_cycles(i, 0);
        }
    }
    cycles /=2;
    //cout << cycles << "\n";
    cout << (cycles > 1 ? "NO\n" : "YES\n");

}