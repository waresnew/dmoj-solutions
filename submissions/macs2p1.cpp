#include <bits/stdc++.h>

// 5/8/2023
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    string a[] = {"N","E","S","W"};
    string d;cin>>d; int l,r;cin>>l>>r;
    int diff = r-l;
    int abs_diff = abs(diff);
    for (int i = 0; i < abs_diff; i++) {
        int cur = -1;
        for (int j = 0; j < 4; ++j) {
            if (a[j]==d) {
                cur=j;break;
            }
        }
        if (diff<0) {
            if (cur - 1 == -1) {
                d = a[3];
            } else {
                d = a[cur - 1];
            }
        } else {
            d=a[(cur+1)%4];
        }
    }
    cout << d << "\n";

}