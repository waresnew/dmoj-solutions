#include <bits/stdc++.h>

// 12/5/2022
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    map<int, int> freq;
    for (int i = 0; i < n; ++i) {
        int r;
        cin >> r;
        freq[r]++;
    }
    vector<pair<int, int>> sorted;
    for (auto &entry: freq) {
        sorted.push_back(entry);
    }
    auto comparator = [](pair<int, int> &a, pair<int, int> &b) {
        return a.second < b.second;
    };
    sort(sorted.begin(), sorted.end(), comparator);
    vector<int> highest, second_highest;
    int prev = sorted[sorted.size()-1].second;
    int second_prev=-1;
    for (int i = sorted.size()-1; i >=0; i--) {
        auto& entry = sorted[i];
        if (entry.second==prev) {
            highest.push_back(entry.first);
        } else if (second_prev==-1||entry.second==second_prev) {
            second_prev=entry.second;
            second_highest.push_back(entry.first);
        }
    }
    sort(highest.begin(), highest.end());
    sort(second_highest.begin(), second_highest.end());
    int ans;
    if (highest.size()==1) {
        ans = max(abs(highest[0]-second_highest[0]), abs(highest[0]-second_highest[second_highest.size()-1]));
    } else  {
        ans = abs(highest[0]-highest[highest.size()-1]);
    }
    cout << ans << "\n";
}