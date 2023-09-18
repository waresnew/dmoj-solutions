#include <bits/stdc++.h>
using namespace std;
int main() {
  cin.sync_with_stdio(0);
  cin.tie(0);
  int scorer;
  cin >> scorer;
  int ans = 0;
  for (int i = 1; i <= 99; i++) {
    for (int j = 1; j <= 99; j++) {
      if (i == j) {
        continue;
      }
      for (int k = 1; k <= 99; k++) {
        if (k == j || k == i) {
          continue;
        }
        for (int l = 1; l <= 99; l++) {
          if (l == k || l == j || l == i) {
            continue;
          }
          if (i < j && j < k && k < l && l == scorer) {
            ans++;
          }
        }
      }
    }
  }
  cout << ans;
}