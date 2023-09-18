#include <bits/stdc++.h>

// 1/24/2023
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int tests;cin>>tests;
    string conversions[] = {
    "",
    "",
    "ABC",
    "DEF",
    "GHI",
    "JKL",
    "MNO",
    "PQRS",
    "TUV",
    "WXYZ"
    };
    for (int test = 0; test < tests; test++) {
        string phone;cin>>phone;
        phone=regex_replace(phone, regex("-"), "");
        string ans="";
        for (int i = 0; i <10; ++i) {
            if (!isdigit(phone[i])) {
                for (int j = 2; j <=9; ++j) {
                    if (conversions[j].find(phone[i])!=string::npos) {
                        ans +=to_string(j);
                        break;
                    }
                }
            } else {
                ans+=phone[i];
            }
        }
        ans.insert(3, "-");
        ans.insert(7, "-");
        cout << ans<<"\n";

    }
}