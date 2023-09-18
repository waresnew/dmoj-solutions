#include <bits/stdc++.h>

// 12/5/2022
using namespace std;



int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    set<pair<int, int>> rectangle_set;
    pair<int, int> rectangles[n];
    for (int i = 0; i < n; ++i) {
        int x, y;
        cin >> x >> y;
        rectangles[i] = pair(x, y);
        rectangle_set.insert(pair(x, y));
    }
    int ans = 0;
    set<set<pair<int,int>>> vis;
    for (int i = 0; i < n; ++i) {
        for (int j = i+1; j < n; ++j) {
            for (int k = j+1; k < n; k++) {
                int x1 = rectangles[i].first, x2 = rectangles[j].first, x3 = rectangles[k].first;
                int y1 = rectangles[i].second, y2 = rectangles[j].second, y3 = rectangles[k].second;
                int len1 = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2), len2 = (x2-x3)*(x2-x3)+(y2-y3)*(y2-y3), len3=(x1-x3)*(x1-x3)+(y1-y3)*(y1-y3);
                if (len3==len1+len2) {
                    auto fourth = pair(x1 + x3 - x2, y1 + y3 - y2);
                    set<pair<int,int>> rectangle;
                    rectangle.insert(rectangles[i]);
                    rectangle.insert(rectangles[j]);
                    rectangle.insert(rectangles[k]);
                    rectangle.insert(fourth);
                    if (rectangle_set.find(fourth) != rectangle_set.end()&&vis.find(rectangle)==vis.end()) {
                        vis.insert(rectangle);
                        ans++;
                    }
                }
            }
        }
    }
    cout << ans << "\n";
}