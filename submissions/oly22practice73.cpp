#include <bits/stdc++.h>

// 12/18/2022
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;cin>>n;
    string input; cin>>input;
    if (input.length()==1) {
        cout << "yes\n";
        return 0;
    }
    int o_count=0;

    int moos = 0;
    bool first = true;
    for (int i = 0; i < input.length(); ++i) {
        if (input[i]=='o') {
            o_count++;
            if (i==0) {
                moos++;
            }
        } else {
            if (o_count!=2) {
                if (!first) {
                    cout << "no\n";
                    return 0;
                }
            }
            o_count =0;
            moos++;
            first=false;
        }
        if (o_count>2) {
            cout << "no\n";
            return 0;
        }
    }
    cout << (moos<=n?"yes\n":"no\n");
}