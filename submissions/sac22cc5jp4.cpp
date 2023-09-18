#include <bits/stdc++.h>

// 6/7/2023
using namespace std;
vector<int> graph[200003];
int in_degree[200003];
vector<int> ans;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;cin>>n;
    for (int i = 1; i <= n; i++) {
        int c;cin>>c;
        in_degree[i]=c;
        for (int j = 0; j < c; ++j) {
            int x;cin>>x;
            graph[x].push_back(i);
        }
    }
    queue<int> queue;
    for (int i=1;i<=n;i++) {
        if (in_degree[i]==0) {
            queue.push(i);
        }
    }
    while (!queue.empty()) {
        int cur = queue.front(); queue.pop();
        for (auto next : graph[cur]) {
           if (--in_degree[next]==0) {
               queue.push(next);
           }
        }
        ans.push_back(cur);
    }
    for (int i = 0; i < n; i++) {
        cout << ans[i]<<" \n"[i==n-1];
    }
}