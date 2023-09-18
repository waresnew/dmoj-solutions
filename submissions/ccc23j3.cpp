#include <bits/stdc++.h>

// 3/7/2023
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;cin>>n;
    int days[5]; memset(days, 0, sizeof(days));
    for (int i = 0; i < n; ++i) {
        string s;cin>>s;
        for (int j = 0; j < 5; ++j) {
            if (s[j]=='Y') {
                days[j]++;
            }
        }
    }
    int most_vis = 0;
    for (int i = 0; i < 5; ++i) {
        if (days[i]>=most_vis) {
            most_vis=days[i];
        }
    }
    vector<int> best_days;
    for (int i = 0; i < 5; ++i) {
        if (days[i]==most_vis) {
            best_days.push_back(i+1);
        }
    }
    if (best_days.size()==1) {
        cout << best_days[0] << "\n"; return 0;
    }
    cout << best_days[0];
    for (int i = 1; i < best_days.size(); i++) {
        cout << ","<<best_days[i];
    }
    cout << "\n";
}