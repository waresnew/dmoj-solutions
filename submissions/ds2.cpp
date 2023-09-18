#include <bits/stdc++.h>

// 12/17/2022
using namespace std;
int parent[100001];
int find_set(int x) {
    if (parent[x]!=x) {
        parent[x]= find_set(parent[x]);
    }
    return parent[x];
}
void union_set(int x, int y) {
    int first = find_set(x), second = find_set(y);
    if (first!=second) {
        parent[second]=first;
    }
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n,m;
    cin>>n>>m;
    int ans = 0;
    for (int i = 1; i <= n; ++i) {
        parent[i]=i;
    }
    string output;
    for (int i = 1; i <= m; ++i) {
        if (ans == n-1) {
            break;
        }
        int a,b; cin>>a>>b;
        if (find_set(a)!=find_set(b)) {
            union_set(a,b);
            output += to_string(i) + "\n";
            ans++;
        }
    }
    if (ans != n-1) {
        cout << "Disconnected Graph\n";
    } else {
        cout << output;
    }

}