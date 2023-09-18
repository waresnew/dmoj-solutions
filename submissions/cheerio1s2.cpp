#include <bits/stdc++.h>

// 4/18/2023
using namespace std;
typedef array<long long, 3> state;

//use priority queue to find top k best answers
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n, a, b;
    cin >> n >> a >> b;
    priority_queue<state, vector<state>, greater<state>> queue;
    for (long long i = 1; i <= n; i++) {
        queue.push({a * i + b, i, 1});
    }
    long long ans = 0;
    for (int count = 0; count < n; count++) {
        auto [cost, i, j] = queue.top();
        queue.pop();
        ans += cost;
        queue.push({a * i + b * (j + 1), i, j + 1});
    }
    cout << ans << "\n";
}