#include <bits/stdc++.h>

// 12/17/2022
using namespace std;
int n,l;
int citations[100001];

bool check(int h) {
    int sum = 0;
    int satisfied = 0;
    for (int i = 0; i < n; ++i) {
        if (satisfied ==h) {
            break;
        }
        if (citations[i]>=h) {
            satisfied++;
            continue;
        }
        if (citations[i]+1==h) {
            sum++;
            satisfied++;
        }
    }
    return sum <= l&&satisfied>=h; //# of citations (sum) required to get h-index of (h)
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>n>>l;
    for (int i = 0; i < n; ++i) {
        cin>>citations[i];
    }
    sort(citations, citations+n, greater<int>());
    int lo=0,hi=n,ans=0;
    while (lo<=hi) {
        int mid = (lo+hi)/2;
        if (check(mid)) {
           ans=mid;
           lo=mid+1;
        } else {
            hi=mid-1;
        }
    }
    cout << ans << "\n";

}