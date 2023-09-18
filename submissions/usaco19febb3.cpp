#include <bits/stdc++.h>

// 12/12/2022
using namespace std;
struct Insn {
    string type;
    int l,r;

    Insn(const string& type, int l, int r) : type(type), l(l), r(r) {}
};
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    vector<Insn> insns;
    for (int i = 0; i < n; ++i) {
        string type;
        int l, r;
        cin >> type >> l >> r;
        insns.push_back(Insn(type,l,r));
    }
    {
        int low = INT_MIN, high = INT_MAX;
        int start = n-1;
        for (int i = n-1; i >=0; --i) {
            Insn insn = insns[i];
            if (insn.type=="none") {
                start=i;
                break;
            }
        }
        for (int i = start; i >=0; i--) {
            Insn insn = insns[i];
            if (insn.type=="none") {
                low=max(insn.l,low);
                high=min(insn.r,high);
            } else {
                if (insn.type=="on") {
                    low -= max(insn.l, insn.r);
                    high -= min(insn.l, insn.r);
                } else if (insn.type=="off") {
                    low+=min(insn.l, insn.r);
                    high += max(insn.l, insn.r);
                }
            }
        }
        cout << max(low,0) << " " << max(high,0) << "\n";
    }
    {
        int low = INT_MIN, high = INT_MAX;
        int start = 0;
        for (int i = 0; i < n; ++i) {
            Insn insn = insns[i];
            if (insn.type == "none") {
                start = i;
                break;
            }
        }
        for (int i = start; i < n; i++) {
            Insn insn = insns[i];
            if (insn.type == "none") {
                low = max(insn.l, low);
                high = min(insn.r, high);
            } else {
                if (insn.type == "on") {
                    low += min(insn.l, insn.r);
                    high += max(insn.l, insn.r);
                } else if (insn.type == "off") {
                    low -= max(insn.l, insn.r);
                    high -= min(insn.l, insn.r);
                }
            }
        }
        cout << max(low,0) << " " << max(high,0) << "\n";
    }
}