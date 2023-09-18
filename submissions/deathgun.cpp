#include <bits/stdc++.h>

using namespace std;

unordered_map<string, int> inDegree;
unordered_map<string, vector<string>> graph;
unordered_map<string,int> order;
unordered_set<string> avoid;
unordered_set<string> cycleStart;
bool dfs(unordered_set<string>& vis, const string& cur) {
    vis.insert(cur);
    for (string next: graph[cur]) {
        if (vis.find(next) != vis.end()) {
            avoid.insert(cur);
            cycleStart.insert(next);
            return true;
        } else {
            vis.insert(next);
            bool result = dfs(vis, next);
            if (result) {
                if (cycleStart.find(cur)!=cycleStart.end()) {
                    return false;
                }
                avoid.insert(cur);
            }
            return result;
        }
    }
    return false;
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int edges;
    cin >> edges;
    int counter=0;
    for (int i = 0; i < edges; i++) {
        string a, b;
        cin >> a;
        cin >> b;
        graph[b].push_back(a);
        if (inDegree.find(a) == inDegree.end()) {
            inDegree[a] = 0;
        }
        if (inDegree.find(b) == inDegree.end()) {
            inDegree[b] = 0;
        }
        if (order.find(a)==order.end()) {
            order[a]=counter++;
        }
        if (order.find(b)==order.end()) {
            order[b]=counter++;
        }
        inDegree[a]++;
    }
    auto greater = [](string a, string b){
        return order[a]>order[b]; //reversed
    };

    priority_queue<string, vector<string>, decltype(greater)> queue(greater);
    for (auto s: inDegree) {
        if (s.second == 0) {
            queue.push(s.first);
        }
    }
    for (auto s: inDegree) {
        if (s.second == 0) {
            unordered_set<string> vis;
            dfs(vis, s.first);
        }
    }

    while (!queue.empty()) {
        string cur = queue.top();
        queue.pop();
        if (avoid.find(cur) != avoid.end()) {
            continue;
        }
        cout << cur << "\n";
        for (string next: graph[cur]) {
            if (--inDegree[next] == 0) {
                if (avoid.find(cur) == avoid.end()) {
                    queue.push(next);
                }
            }
        }
    }

}