#include <bits/stdc++.h>

// 11/28/2022
using namespace std;

struct Coordinate {
    int x_, y_;

    Coordinate(int x = 0, int y = 0) {
        x_ = x;
        y_ = y;
    }
};

auto hasher = [](const Coordinate &pt) {
    return (size_t) (pt.x_ * 31 + pt.y_);
};

auto equaler = [](const Coordinate &pt1, const Coordinate &pt2) {
    return ((pt1.x_ == pt2.x_) && (pt1.y_ == pt2.y_));
};

unordered_set<Coordinate, decltype(hasher), decltype(equaler)> coords(10, hasher, equaler);

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int x, y;
        cin >> x >> y;
        coords.insert(Coordinate(x, y));
    }
    int ans = 0;
    for (const Coordinate& coord: coords) {
        for (const Coordinate& coord2: coords) {
            if (&coord == &coord2) {
                continue;
            }
            if (coords.find(Coordinate(coord.x_, coord2.y_)) != coords.end() &&
                coords.find(Coordinate(coord2.x_, coord.y_)) != coords.end()) {
                ans = max(ans, abs(coord.x_ - coord2.x_) * abs(coord.y_ - coord2.y_));
            }
        }
    }
    cout << ans << "\n";
}