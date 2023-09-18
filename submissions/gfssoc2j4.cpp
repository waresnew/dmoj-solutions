#include <bits/stdc++.h>
using namespace std;

int psa[500001];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int number_of_episodes, queries;
    cin >> number_of_episodes;
    cin >> queries;
    for (int i = 1; i <= number_of_episodes;i++) {
        cin >> psa[i];
        psa[i] += psa[i-1];
    }
    for (int i = 0; i < queries; i++) {
        int a, b;
        cin >> a;
        cin >> b;
        cout << psa[number_of_episodes]-(psa[b]-psa[a-1]) << "\n";
    }
}