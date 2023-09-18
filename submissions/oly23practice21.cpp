#include <bits/stdc++.h>

// 6/11/2023
using namespace std;
int medians[100];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;cin>>n;
    for (int i = 0; i < n; ++i) {
        int row[100];
        for (int j = 0; j < n; ++j) {
            cin>>row[j];
        }
        sort(row, row+n);
        for (int j = 0; j < n; ++j) {
            if (j==n/2) {
                medians[i]=row[j];
            }
        }
    }
    sort(medians, medians+n);
    for (int i = 0; i < n; ++i) {
        if (i==n/2) {
            cout << medians[i]<<"\n";
            return 0;
        }
    }
}