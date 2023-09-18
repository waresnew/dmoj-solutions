#include <bits/stdc++.h>

// 6/6/2023
using namespace std;
int n, ans=0;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    for (cin>>n; n;n--) {
        int a,b;cin>>a>>b;
        if(a>b)ans++;
    }
    cout<<ans<<"\n";
}