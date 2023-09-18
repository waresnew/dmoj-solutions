#include <bits/stdc++.h>

// 12/17/2022
using namespace std;
int n;

bool check(char arr[], int max_dis) { //2 subarrays of max_dis+1 occurances of 0
    int count = 0;
    int ans = 0;
    for (int i = 0; i < n; ++i) {
        if (arr[i] == '0') {
            count++;
            if ((count - 1) / 2 >= max_dis-1||(i==n-1&&count>=max_dis)){
                ans++;
                count/=2;
            }

        } else {
            count = 0;
        }
    }
    return ans>=2;
}


int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    char input[n];
    cin >> input;
    int count = 0;
    for (int i = 0; i < n; ++i) {
        if (input[i]=='1') {
            count++;
            break;
        }
    }
    if (count==0) {
        cout << n-1 << "\n";
        return 0;
    }
    int lo = 0, hi = n - 1, ans = 0;
    while (lo <= hi) {
        int mid = (lo + hi) / 2;
        if (check(input, mid)) {
            ans = mid;
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
    }

    if (input[0]=='0' && input[n-1]=='0') {
        int edited_ans=n-1, counter=0;
        for (int i = 1; i < n-1; ++i) {
            if (input[i]=='0') {
                counter++;

            } else {
                edited_ans=min(edited_ans, counter);
                counter=0;
            }
        }
        edited_ans=min(edited_ans, counter);
        ans=max(edited_ans+1, ans);
    }
    int edited_ans = INT_MAX, counter = 0;
    bool start = false;
    for (int i = 0; i < n; ++i) {
        if (input[i] == '0' && start) {
            counter++;
        } else {
            if (input[i]=='1') {
                start = true;
            }
            if (counter > 0) {
                edited_ans = min(edited_ans, counter);
            }
            counter = 0;
        }
    }
    if (edited_ans!=INT_MAX) {
        ans = min(edited_ans + 1, ans);
    }
    cout << ans << "\n";
}