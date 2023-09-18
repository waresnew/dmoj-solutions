#include <bits/stdc++.h>

// 2/14/2023
using namespace std;
typedef pair<int, int> pii;
int r, c;
char grid[30][30];
bool ans[30][30];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    for (int test = 0; test < 5; test++) {
        for (int i = 0; i < 30; ++i) {
            for (int j = 0; j < 30; ++j) {
                grid[i][j]=0;
                ans[i][j]=0;
            }
        }
        cin >> r >> c;
        for (int i = 0; i < r; i++) {
            string line;
            while (line == "") getline(cin, line);
            for (int j = 0; j < c; ++j) {
                grid[i][j] = line[j];
            }
        }
        int m;
        cin >> m;
        string words[m];
        for (int i = 0; i < m; ++i) {
            string s;
            while (s == "") getline(cin, s);
            s=regex_replace(s, regex("[^A-Z]"), "");
            words[i] = s;
        }
        for (auto& word : words) {
            for (int r_offset = -1; r_offset <= 1; r_offset++) {
                for (int c_offset=-1; c_offset<=1; c_offset++) {
                    for (int i = 0; i < r; ++i) {
                        for (int j = 0; j < c; ++j) {
                            if (grid[i][j]==word[0]) {
                                vector<pii> path;
                                path.push_back(pii(i,j));
                                if (word.length()>1) {
                                    for (int k = 1; k < word.length(); k++) {
                                        if (grid[i + r_offset * k][j + c_offset * k] == word[k]) {
                                            path.push_back(pii(i + r_offset * k, j + c_offset * k));
                                        } else {
                                            break;
                                        }
                                    }
                                    if (path.size()==word.length()) {
                                        for (auto& [x,y] : path) {
                                            ans[x][y]=true;
                                        }
                                    }
                                } else {
                                    ans[i][j]=true;
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (!ans[i][j]) {
                    cout << grid[i][j];
                }
            }
        }
        cout << "\n";

    }
}