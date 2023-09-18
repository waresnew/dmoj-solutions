#include <bits/stdc++.h>

using namespace std;
int psa[1000001];
int main() {
    int n; cin>>n;
    for (int i = 1; i <= n;i++) {
        cin>>psa[i];
        psa[i]+=psa[i-1];
    }
    int q; cin>>q;
    for (int i = 0; i < q; i++) {
        int l,r;cin>>l>>r;
        int sum = psa[r]-psa[l-1];
        int count =r-l+1;
        cout << sum << " " << sum/count<<"\n";
    }
    return 0;
}