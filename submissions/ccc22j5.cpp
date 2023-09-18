#include <bits/stdc++.h>

// 2/14/2023
using namespace std;
typedef pair<int,int> pii;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n,t;cin>>n>>t;
    pii trees[t+2];
    for (int i = 0; i < t; ++i) {
        int r,c;cin>>r>>c;
        trees[i]=pii(r,c);
    }
    trees[t]=pii(0,0);
    trees[t+1]=pii(n+1, n+1);
    int ans = 0;
    for (auto& left : trees) {
        for (auto& right : trees) {
            if (left==right||left.second>right.second) {
                continue;
            }
            vector<pii> inside;
            for (auto& tree : trees) {
                if (tree.second > left.second&&tree.second<right.second) {
                    inside.push_back(tree);
                }
            }
            inside.push_back(pii(0,0));
            inside.push_back(pii(n+1, n+1));
            sort(inside.begin(), inside.end());
            for (int i = 0; i < inside.size()-1; i++) {
                ans = max(ans, min(abs(left.second-right.second)-1,abs(inside[i+1].first-inside[i].first)-1));
            }
        }
    }
    cout << ans << "\n";
}