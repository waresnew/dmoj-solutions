#include <bits/stdc++.h>

// 5/2/2023
using namespace std;
int dp[103][103];
pair<string, int> people[103];
pair<string, int> slowest[103][103];
vector<string> groups[103][103];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int m;
    cin >> m;
    int n;
    cin >> n;
    memset(dp, 0x3f, sizeof(dp));
    for (int i = 1; i <= n; i++) {
        string name;
        cin >> name;
        int slow;
        cin >> slow;
        people[i] = make_pair(name, slow);
        dp[i][i] = people[i].second;
        groups[i][i].push_back(name);
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            int best = INT_MIN;
            string best_name = "";
            for (int k = i; k <= j; k++) {
                if (best < people[k].second) {
                    best_name = people[k].first;
                    best = people[k].second;
                }
            }
            slowest[i][j] = make_pair(best_name, best);
        }
    }
    for (int l = 2; l <= n; l++) {
        for (int i = 1, j = i + l - 1; j <= n; i++, j++) {
            if (l <= m) {
                dp[i][j] = slowest[i][j].second;
                string result = people[i].first;
                for (int k = i+1; k <= j; k++) {
                    result += " " + people[k].first;
                }
                groups[i][j].push_back(result);
                continue;
            }
            int bestK = i;
            for (int k = i; k <= min(j, i + m); k++) {
                if (k - i + 1 > m) {
                    continue;
                }
                if (dp[k + 1][j] + slowest[i][k].second < dp[i][j]) {
                    dp[i][j] = dp[k + 1][j] + slowest[i][k].second;
                    bestK = k;
                }
            }
            groups[i][j].clear();
            string second = people[i].first;
            for (int k = 0; k < groups[bestK + 1][j].size(); k++) {
                groups[i][j].push_back(groups[bestK + 1][j][k]);
            }
            for (int k = i + 1; k <= bestK; k++) {
                second += " " + people[k].first;
            }
            groups[i][j].push_back(second);
        }
    }
    cout << "Total Time: " << dp[1][n] << "\n";
    for (int i = groups[1][n].size()-1; i >= 0; i--) {
        cout << groups[1][n][i] << "\n";
    }


}