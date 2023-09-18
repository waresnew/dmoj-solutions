#include <bits/stdc++.h>
using namespace std;
vector<int> history;
int possession[500001];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n, m, q;
    cin >> n >> m >> q;

    for (int i = 0; i < q; i++) {
        char command;
        cin >> command;
        if (command == 'b') {
            int s;
            cin >> s;
            if (n ==0) {
                continue;
            }
            n--;
            possession[s]++;
            history.push_back(s);
        } else if (command == 'r') {
            int s;
            cin >> s;
            n++;
            possession[s]--;
        }else if (command == 'p') {
            int s;
            cin >> s;
            cout << possession[s] << "\n";
        }else if (command == 'c') {
            cout << n << "\n";
        }else if (command == 'l') {
            int x;
            cin >> x;
            cout << history.at(history.size()-x) << "\n";

        }
    }

}