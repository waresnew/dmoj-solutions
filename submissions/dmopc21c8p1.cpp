#include <bits/stdc++.h>

// 5/1/2023
using namespace std;
typedef pair<int, int> pii;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n, m;
    cin >> n >> m;
    multiset<int> shops;
    for (int i = 0; i < n; i++) {
        int a;
        cin >> a;
        shops.insert(a);
    }

    vector<int> valid;
    valid.push_back(*shops.begin());
    shops.erase(shops.begin());
    int prev = valid[0];
    for (int i = 1; i < n; i++) {
        auto it = shops.lower_bound(m - prev);
        if (it == shops.end()) {
            cout << "-1\n";
            return 0;
        }
        int val = *it;
        valid.push_back(val);
        shops.erase(it);
        prev = val;
    }
    for (int i = 0; i < valid.size(); i++) {
        cout << valid[i] << (i == valid.size() - 1 ? "\n" : " ");
    }

}