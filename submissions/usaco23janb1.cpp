#include <bits/stdc++.h>

// 2/9/2023
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;cin>>n;
    string cows;cin>>cows;
    int lists[n+1];
    for (int i = 1; i <= n; ++i) {
        cin>>lists[i];
    }
    int g = 0, h = 0;
    for (int i = 1; i <= n; i++) if (cows[i-1]=='G')g++;else h++;
    int g_leader = 0, h_leader=0;
    for (int i = 1; i <= n; i++) {
        if (cows[i-1]=='G') {
            int has = 0;
            for (int j = i; j <= lists[i]; ++j) {
                if (cows[j-1]=='G') {
                    has++;
                }
            }
            if (has==g) {
                g_leader=i;
            }
            break;
        }
    }
    for (int i = 1; i <= n; i++) {
        if (cows[i-1]=='H') {
            int has = 0;
            for (int j = i; j <= lists[i]; j++) {
                if (cows[j-1]=='H') {
                    has++;
                }
            }
            if (has==h) {
                h_leader=i;
            }
            break;
        }
    }
    int has_g = 0, has_h = 0;
  for (int i = 1; i <= n; i++) {
      if (cows[i-1]=='G') {
          if (i<h_leader&&lists[i]>=h_leader) {
              has_h++;
          }
      } else {
          if (i<g_leader&&lists[i]>=g_leader) {
              has_g++;
          }
      }
  }
  cout << has_g*min(1,g_leader)+has_h*min(1,h_leader)+min(g_leader, h_leader)<<"\n";

}