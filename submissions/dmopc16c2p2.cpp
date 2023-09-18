#include <bits/stdc++.h>

// 12/17/2022
using namespace std;
int parent[100001];
int find_set(int x) {
    if (parent[x]!=x) {
        parent[x]=find_set(parent[x]);
    }
    return parent[x];
}
void union_set(int x, int y) {
    int first = find_set(x), second = find_set(y);
    if (first!=second) {
        parent[first]=second;
    }
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n,m;cin>>n>>m;
    for (int i = 1; i <=n; ++i) {
        parent[i]=i;
    }
    for (int i = 0; i < m; ++i) {
        int k; cin>>k;
        int students[k];
        for (int j = 0; j < k; ++j) {
            cin>>students[j];
        }
        //sort(students, students+k);
        for (int j = 0; j < k; j++) {
            union_set(students[j], students[0]);
        }
    }
    vector<int> ans;
    for (int i = 1; i <= n; ++i) {
        if (find_set(1)==find_set(i)) {
            ans.push_back(i);
        }
    }
    cout << ans.size()<<"\n";
    for (int i = 0; i < ans.size(); ++i) {
        cout << ans[i];
        if (i != ans.size()-1) {
            cout << " ";
        }
    }
    cout << "\n";
}