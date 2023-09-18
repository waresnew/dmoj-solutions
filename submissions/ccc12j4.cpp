#include <bits/stdc++.h>
using namespace std;

int main() {
  cin.sync_with_stdio(0);
  cin.tie(0);
  int k;
  string input;
  cin >> k;
  cin >> input;
  for (long unsigned int i = 0; i < input.length(); i++) {
    int shift = 3 * (i + 1) + k;
    char cur = input.at(i);
    for (int j = 0; j < shift; j++) {
      if (cur == 'A') {
        cur = 'Z';
        continue;
      }
      cur--;
    }
    cout << cur;
  }
  cout << "\n";
}