#include <bits/stdc++.h>

// 11/29/2022
using namespace std;
int left_shoes[100000], right_shoes[100000];
int n, m;

bool check(int dis) {
    int count = 0;
    for (int left=0, right=0; left<n&&right<m;) {
        if (abs(left_shoes[left] - right_shoes[right]) <= dis) {
            right++;
            left++;
            count++;
        } else if (left_shoes[left]<right_shoes[right]){
            left++;
        } else {
            right++;
        }
    }
    return count >= min(n, m);
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        cin >> left_shoes[i];
    }
    for (int i = 0; i < m; i++) {
        cin >> right_shoes[i];
    }
    sort(left_shoes, left_shoes + n);
    sort(right_shoes, right_shoes + m);
    int low = 0, high = INT_MAX;
    int ans = 0;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (check(mid)) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    cout << ans << "\n";
}