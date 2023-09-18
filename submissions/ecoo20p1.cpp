#include <bits/stdc++.h>

// 4/24/2023
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    string order[] = {
            "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C","C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C","C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C","C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B","C"
    };
    int T;cin>>T;
    for (int t = 0; t < T; t++) {
       string sequence[8];
       for (int i = 0; i < 4; i++) {
           cin>>sequence[i];
           sequence[i+4] = sequence[i];
       }
       int pos[4];
       int prev = -1;
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 48; j++) {
                if (order[j]==sequence[i]&&j>prev) {
                    pos[i]=j;
                    prev = j;
                    break;
                }
            }
        }
        int dis1 = pos[1]-pos[0], dis2 = pos[2]-pos[1], dis3 = pos[3]-pos[2];
        if (dis1==4&&dis2==3&&dis3==3) cout << "root\n";
        else if (dis1==3&&dis2==3&&dis3==2) cout << "first\n";
        else if (dis1==3&&dis2==2&&dis3==4) cout << "second\n";
        else if (dis1==2&&dis2==4&&dis3==3) cout << "third\n";
        else cout << "invalid\n";

    }
}