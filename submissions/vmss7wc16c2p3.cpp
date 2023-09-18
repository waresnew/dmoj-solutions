#include <bits/stdc++.h>

// 3/26/2023
using namespace std;
int pos[1000001];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;cin>>n;
    for (int i = 1; i <= n; ++i) {
        int x;cin>>x;
        pos[x]=i;
    }
    int m;cin>>m;
    vector<int> list;
    for (int i = 1; i <= m; ++i) {
        int x;cin>>x;
        if (pos[x]==0) continue;
        if (list.empty()||pos[x]>list.back()) {
            list.push_back(pos[x]);
        } else {
            *lower_bound(list.begin(), list.end(), pos[x])=pos[x];
        }
    }
    cout<<list.size()<<"\n";
}