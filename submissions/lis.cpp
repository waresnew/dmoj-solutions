#include <bits/stdc++.h>

// 3/25/2023
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;cin>>n;
    int a[n];
    for (int i = 0; i < n; ++i) {
        cin>>a[i];
    }
    vector<int> list;
    for (int i : a) {
        if (list.size()==0||i>list[list.size()-1]) {
            list.push_back(i);
        } else {
            *lower_bound(list.begin(), list.end(), i)=i;
        }
    }
    cout << list.size()<<"\n";
}