#include <bits/stdc++.h>

using namespace std;
int possession[500001];
vector<int> history;

int main() {
    int n,m,q;cin>>n>>m>>q;
    for (int i = 0; i < q; i++) {
        string type; cin>>type;
        if (type=="b") {
            int s; cin>>s;
            if (n==0) continue;
            possession[s]++;
            history.push_back(s);
            n--;
        } else if (type=="r") {
            int s;cin>>s;
            possession[s]--;
            n++;
        } else if (type=="p") {
            int s; cin>>s;
            cout << possession[s]<<"\n";
        } else if (type=="c") {
            cout << n<<"\n";
        } else if (type=="l") {
            int x; cin>>x;
            cout << history[history.size()-x]<<"\n";
        }
    }
    return 0;
}