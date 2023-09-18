#include <bits/stdc++.h>
using namespace std;
int rate;
int years;
long long target;
bool check(long long start) {
    long long cur=0;
    for (long long i = 0; i < years;i++) {
        cur += start;

        cur+=cur*rate/100;
        if (cur>=target) {
            return true;
        }
    }

    return false;
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin >> rate >> years >> target;
    long long low = 0, high = LONG_LONG_MAX;
    long long ans = 0;
    while (low <= high) {
        long long mid = (low + high) / 2;
        if (check(mid)) {
            high =mid-1;
            ans=mid;
        } else {
            low = mid+1;
        }
    }
    cout << ans << "\n";

}