#include <bits/stdc++.h>

// 11/28/2022
using namespace std;
bool grid[402][402];

void fill(int row, int col) {
    grid[row + 200][col + 200] = true;
}
bool query(int row, int col) {
    return grid[row+200][col+200];
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    fill(-1, 0);
    fill(-2, 0);
    fill(-3, 0);
    fill(-3, 1);
    fill(-3, 2);
    fill(-3, 3);
    fill(-4, 3);
    fill(-5, 3);
    fill(-5, 4);
    fill(-5, 5);
    fill(-4, 5);
    fill(-3, 5);
    fill(-3, 6);
    fill(-3, 7);
    fill(-4, 7);
    fill(-5, 7);
    fill(-6, 7);
    fill(-7, 7);
    fill(-7, 6);
    fill(-7, 5);
    fill(-7, 4);
    fill(-7, 3);
    fill(-7, 2);
    fill(-7, 1);
    fill(-7, 0);
    fill(-7, -1);
    fill(-6, -1);
    fill(-5, -1);
    int row = -5, col = -1;
    while (true) {
        char command;
        int len;
        cin >> command >> len;
        bool danger = false;
        if (command == 'd') {
            for (int i = row-1; i >= row-len; i--) {
                if (query(i, col)) {
                    danger = true;
                }
                fill(i,col);
            }
            row-=len;
        } else if (command == 'u') {
            for (int i = row+1; i <= row+len; i++) {
                if (query(i, col)) {
                    danger = true;
                }
                fill(i,col);
            }
            row+= len;
        } else if (command == 'l') {
            for (int i = col-1; i >= col-len; i--) {
                if (query(row, i)) {
                    danger = true;
                }
                fill(row,i);
            }
            col -= len;
        } else if (command == 'r') {
            for (int i = col+1; i <=col+len; i++) {
                if (query(row, i)) {
                    danger = true;
                }
                fill(row,i);
            }
            col+=len;
        } else if (command == 'q') {
            break;
        }
        fill(row, col);
        cout << col << " " << row;
        cout << (danger?" DANGER":" safe")<<"\n";
        if (danger) {
            break;
        }
    }

}