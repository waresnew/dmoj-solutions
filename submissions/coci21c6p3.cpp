#include <bits/stdc++.h>

// 11/29/2022
using namespace std;
int in_degree[200001];
int charge[200001];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n, m;
    cin >> n >> m;
    unordered_set<int> graph[n + 1];


    for (int i = 0; i < m; ++i) {
        int a, b;
        cin >> b >> a; //reversed on purpose
        in_degree[b]++;
        graph[a].insert(b);
        charge[b] = 1;
        charge[a] = 0;
    }
    queue<int> queue;
    for (int i = 1; i <= n; ++i) {
        if (in_degree[i] == 0) {
            queue.push(i);
        }
    }
    int count = 0;
    vector<int> order;
    while (!queue.empty()) {
        int cur = queue.front();
        queue.pop();
        count++;
        order.push_back(cur);
        for (int next: graph[cur]) {
            if (--in_degree[next] == 0) {
                queue.push(next);
            }
        }
    }


    if (count != n) {
        cout << -1 << "\n";
        return 0;
    }
    string output;
    for (int i: order) {
        output += to_string(i) + " 1\n";
    }
    cout << n << "\n" << output;
}