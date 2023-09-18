#include <bits/stdc++.h>

// 2/2/2023
using namespace std;
//minimize danger first, then distance
vector<pair<int,bool>> graph[100001];
struct State {
    int val,dis, total_danger;

    State(int val,int dis, int totalDanger) : val(val), dis(dis), total_danger(totalDanger) {}

    bool operator<(const State& rhs) const {
        return total_danger==rhs.total_danger?dis < rhs.dis:total_danger < rhs.total_danger;
    }

    bool operator>(const State& rhs) const {
        return rhs < *this;
    }

    bool operator<=(const State& rhs) const {
        return !(rhs < *this);
    }

    bool operator>=(const State& rhs) const {
        return !(*this < rhs);
    }
};
int dis[100001];
int danger_dis[100001];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n,m;cin>>n>>m;
    for (int i = 0; i < m; ++i) {
        int a,b,t;cin>>a>>b>>t;
        graph[a].push_back(pair(b,t)); graph[b].push_back(pair(a,t));
    }
    fill(dis, dis+100001, 1e9);
    fill(danger_dis, danger_dis+100001, 1e9);
    dis[1]=0;
    danger_dis[1]=0;
    priority_queue<State, vector<State>, greater<State>> queue;
    queue.push(State(1,0,0));
    int min_danger = INT_MAX, min_dis = INT_MAX;
    while (!queue.empty()) {
        auto cur = queue.top(); queue.pop();
        if (cur.val==n) {
            if (cur.total_danger<min_danger) {
                min_danger=cur.total_danger;
                min_dis=dis[n];
            }
            if (cur.total_danger==min_danger) {
                min_dis=min(min_dis, dis[n]);
            }
        }
        for (auto& [next, danger] : graph[cur.val]) {
            if (State(next, dis[cur.val]+1, cur.total_danger+danger)<State(next, dis[next], danger_dis[next])) {
                dis[next]=dis[cur.val]+1;
                danger_dis[next]=cur.total_danger+danger;
                queue.push(State(next, dis[next], cur.total_danger+danger));
            }
        }
    }
    if (min_danger==INT_MAX) {
        cout << "-1\n"; return 0;
    }
    cout << min_danger << " " << min_dis << "\n";
}