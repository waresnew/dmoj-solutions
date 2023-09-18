#include <bits/stdc++.h>

// 11/28/2022
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    int s = 0, t = 0;
    string d;
    getline(cin, d);

    for (int i = 0; i < n; i++) {
        string input;
        getline(cin, input);
        for (int j = 0; j < input.length(); j++) {
            if (input.at(j)=='s'||input.at(j)=='S') {
                s++;
            }
            if (input.at(j)=='t'||input.at(j)=='T') {
                t++;
            }
        }
    }
    cout << (t>s?"English":"French")<<"\n";
}