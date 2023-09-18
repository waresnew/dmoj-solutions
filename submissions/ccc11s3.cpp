#include <bits/stdc++.h>

// 1/24/2023
using namespace std;
bool gen_crystal(int cur_mag, int target_x, int target_y) {
    if (cur_mag==0) {
        return false;
    }
    int offset = pow(5, cur_mag-1);
    int cur_x=target_x/offset, cur_y=target_y/offset;
    if ((cur_x<=3&&cur_x>=1&&cur_y==0)||(cur_x==2&&cur_y==1)) {
        return true;
    } else if ((cur_y==1&&(cur_x==1||cur_x==3))||(cur_y==2&&cur_x==2)) {
        return gen_crystal(cur_mag-1, target_x%offset, target_y%offset);
    } else {
        return false;
    }

}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int tests;cin>>tests;
    for (int test = 0; test < tests; test++) {
        int mag,x,y;cin>>mag>>x>>y;
        cout << (gen_crystal(mag, x, y)?"crystal\n":"empty\n");
    }
}