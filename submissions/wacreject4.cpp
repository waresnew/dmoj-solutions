#include <bits/stdc++.h>

// 4/9/2023
using namespace std;
int n;
int a[300001], b[300001];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>n;
    for (int i = 1; i <= 10000; i++) {
        cout << i << " " << i << endl;
        int s,t;cin>>s;
        if (s==-1) {
            return 0;
        }
        cin>>t;
        a[i]=s; b[i]=t;
        for (int j = 1; j <= 300000; j++) {
            if (a[j]==t) {
                cout << j << " " << i << endl;
                return 0;
            } else if (s==b[j]) {
                cout << i << " " << j << endl;
                return 0;
            }
        }
    }
}