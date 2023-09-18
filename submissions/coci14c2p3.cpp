#include <bits/stdc++.h>

// 3/26/2023
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    int k;
    cin >> k;
    pair<int, int> a[n];
    for (int i = 0; i < n; ++i) {
        int c;
        cin >> c;
        a[i] = {c, i};
    }
    sort(a, a + n);
    int teams[n];
    for (int i = 0; i < n; ++i) {
        teams[a[i].second] = i / k;
    }
    vector<int> list;
    for (int i: teams) {
        if (list.size() == 0 || i >= list[list.size() - 1]) {
            list.push_back(i);
        } else {
            *upper_bound(list.begin(), list.end(), i) = i;
        }
    }
    cout << n-list.size() << "\n";
}