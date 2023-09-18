#include <bits/stdc++.h>

// 9/9/2023
using namespace std;
int n,m;
long long bit[100001], bit2[100001], a[100001], freq[100001];
long long sum(int max, long long bi[]) {
    long long summ = 0;
    for (int i = max; i >= 1; i-=i&-i) {
        summ+=bi[i];
    }
    return summ;
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>n>>m;
    for (int i = 1; i <= n; ++i) {
        int val;cin>>val;
        a[i]=val;
        freq[val]++;
        for (int j = i; j <= n; j+=j&-j) {
            bit[j]+=val;
        }
    }
    for (int i = 1; i <= 100000; i++) {
        for (int j = i; j <= 100000; j+=j&-j) {
            bit2[j]+=freq[i];
        }
    }
    for (int q = 0; q < m ;q++) {
        string type;cin>>type;
        if (type=="C") {
            int x,v;cin>>x>>v;
            int old = a[x];
            a[x]=v;
            for (int i = x; i <= n; i += i&-i) {
                bit[i] += -old+v;
            }
            for (int i = v; i <= 100000; i+=i&-i) {
                bit2[i]++;
            }
            for (int i = old; i <= 100000; i+=i&-i) {
                bit2[i]--;
            }
        } else if (type=="S") {
            int l,r;cin>>l>>r;
            cout << sum(r,bit)-sum(l-1,bit)<<"\n";
        } else if (type == "Q") {
            int v; cin>>v;
            cout << sum(v, bit2)<<"\n";
        }
    }
}