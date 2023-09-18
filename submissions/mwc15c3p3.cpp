#include <bits/stdc++.h>

// 1/29/2023
using namespace std;

char grid[25][25];
int n,q;
bool dfs(pair<int,int> cur, string str, bool vis[25][25], string& word) {
    if (word==str) {
        return true;
    }
    pair<int,int> nexts[] = {
            pair(cur.first+1, cur.second),
            pair(cur.first+1, cur.second+1),
            pair(cur.first+1, cur.second-1),
            pair(cur.first-1, cur.second),
            pair(cur.first-1, cur.second-1),
            pair(cur.first-1, cur.second+1),
            pair(cur.first, cur.second+1),
            pair(cur.first, cur.second-1)
    };
    for (auto& next : nexts) {
        if (next.first<0||next.second<0||next.first>=n||next.second>=n) continue;
        if (!vis[next.first][next.second] && grid[next.first][next.second]==word[str.length()]) {
            vis[next.first][next.second]=true;
            if (dfs(pair(next.first, next.second), str+word[str.length()], vis, word)) {
                return true;
            }
        }
    }
    return false;
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>n>>q;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            char input; cin>>input;
            grid[i][j]=tolower(input);
        }
    }
    for (int i = 0; i < q; ++i) {
        string word; cin>>word;
        for (int j = 0; j < word.length(); ++j) {
            word[j]=tolower(word[j]);
        }
        vector<pair<int,int>> starts;
        for (int j = 0; j < n; ++j) {
            for (int k = 0; k < n; ++k) {
                if (grid[j][k]==word[0]) {
                    starts.push_back(pair(j, k));
                }
            }
        }
        for (auto& start : starts) {
            bool vis[25][25];
            for (int j = 0; j < 25; ++j) {
                for (int k = 0; k < 25; ++k) {
                    vis[j][k]=false;
                }
            }
            vis[start.first][start.second]=true;
           if (dfs(start, string(1,word[0]), vis, word)) {
               cout << "good puzzle!\n";
               goto label;
           }
        }
        cout << "bad puzzle!\n";
        label:;
    }
}