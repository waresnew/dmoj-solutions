#include <bits/stdc++.h>

// 2/12/2023
using namespace std;


int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int q;cin>>q;
    for (int test = 0; test < q; test++) {
        string input;cin>>input;
        if (input.size()<3) {
            cout << "-1\n";
            continue;
        }
        vector<array<char,3>> segments;
        for (int i = 1; i <= input.size()-2;i++) {
            char first = input[i-1], second = input[i], third = input[i+1];
            if (second != 'M') {
                segments.push_back({first,second,third});
            }
        }
        int ans = INT_MAX;
        for (auto& segment : segments) {
            int moves = 0;
            if (segment[0]!='M') moves++;
            if (segment[2]!='O') moves++;
            ans = min(ans, moves);
        }
        if (ans==INT_MAX) {
            cout << "-1\n";
        } else {
            cout << ans+input.size()-3 << "\n";
        }

    }
}