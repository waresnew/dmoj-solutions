#include <bits/stdc++.h>

// 3/7/2023
using namespace std;
map<char, int> green;
int n, m;

int dp[11];
int ans = 0;
int get_score(int k, int o, int r, int d) {
    int start = d*d+k*k+o*o+r*r;
    int croc = min(k/2, min(o/2, min(r, d)));
    return start+7*croc;
}
void dfs(int i, int k, int o, int r, int d, int score) {
    if (i >=m) {
        ans = max(ans,score );
        return;
    }
    dfs(i+1, k+1,o,r,d,get_score(k+1,o,r,d));
    dfs(i+1, k,o+1,r,d,get_score(k,o+1,r,d));
    dfs(i+1, k,o,r+1,d,get_score(k,o,r+1,d));
    dfs(i+1, k,o,r,d+1,get_score(k,o,r,d+1));
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    string s;
    cin >> s;
    for (int i = 0; i < n; ++i) {
        green[s[i]]++;
    }
    int start = green['d']*green['d']+green['k']*green['k']+green['o']*green['o']+green['r']*green['r'];
    start += 7*(min(green['k']/2, min(green['o']/2, min(green['r'], green['d']))));
    dfs(0, green['k'], green['o'], green['r'], green['d'], start);
    cout << ans << "\n";
}