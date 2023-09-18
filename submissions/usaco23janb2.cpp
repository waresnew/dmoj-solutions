#include <bits/stdc++.h>

// 2/12/2023
using namespace std;
int cows[101];
int ans = INT_MAX;

struct Cooler {
    int val, from, to, cool, cost;

    Cooler(int val, int from, int to, int amount, int cost) : val(val), from(from), to(to), cool(amount), cost(cost) {}

    Cooler() {}
};

Cooler coolers[10];
int n, m;

void brute(int cur,vector<Cooler> picked) {
    if (cur>=m) {
        int cooled[102];
        int total_cost = 0;
        fill(cooled, cooled + 102, 0);
        for (Cooler cooler: picked) {
            total_cost += cooler.cost;
            cooled[cooler.from] += cooler.cool;
            cooled[cooler.to + 1] -= cooler.cool;
        }
        for (int i = 1; i <= 100; i++) {
            cooled[i] += cooled[i - 1];
        }
        bool flag = true;
        for (int i = 1; i <= 100; ++i) {
            if (cooled[i] < cows[i]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            ans = min(ans, total_cost);
        }
        return;
    }
    brute(cur+1, picked);
    picked.push_back(coolers[cur]);
    brute(cur+1, picked);
    picked.pop_back();
}

vector<Cooler> vis;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        int from, to, amount;
        cin >> from >> to >> amount;
        for (int j = from; j <= to; j++) {
            cows[j] = amount;
        }
    }
    for (int i = 0; i < m; ++i) {
        int from, to, cool, cost;
        cin >> from >> to >> cool >> cost;
        coolers[i] = Cooler(i, from, to, cool, cost);
    }
    brute(0,vis);
    cout << ans << "\n";

}