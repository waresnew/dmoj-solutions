#include <bits/stdc++.h>

// 12/6/2022
using namespace std;
int parent[200001];
int find(int x) {
    if (parent[x]!=x) {
        parent[x]=find(parent[x]);
    }
    return parent[x];
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n, q;
    cin >> n >> q;

    for (int i = 1; i <=n ; ++i) {
        parent[i]=i;
    }
    for (int i = 0; i < q; ++i) {
        char type;
        cin >> type;
        int x,y;
        cin >> x >> y;
        if (type=='A') {
            int first = find(x), second = find(y);
            if (first!=second) {
                parent[second]=first;
            }
        } else {
            int first = find(x), second = find(y);
            cout << (first==second?"Y":"N") << "\n";
        }
    }
}