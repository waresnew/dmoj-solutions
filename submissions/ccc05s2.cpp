#include <bits/stdc++.h>

// 1/24/2023
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int x_max, y_max;
    cin >> x_max >> y_max;
    int x = 0, y = 0;
    while (true) {
        int x_move, y_move;
        cin >> x_move >> y_move;
        bool x_flag=false,y_flag=false;
        if (x_move == 0 && y_move == 0) break;
        if (x + x_move < 0) {
            x = 0; x_flag=true;
        }
        if (x + x_move > x_max) {
            x = x_max; x_flag=true;
        }
        if (y + y_move < 0) {
            y = 0; y_flag=true;
        }
        if (y + y_move > y_max) {
            y = y_max; y_flag=true;
        }
        x=!x_flag?x+x_move:x;
        y=!y_flag?y+y_move:y;
        cout << x<< " " <<y << "\n";
    }
}