#include <bits/stdc++.h>

// 12/11/2022
using namespace std;

struct Computer {
    string name;
    int ram, cpu, disk;

    Computer(const string& name, int ram, int cpu, int disk) : name(name), ram(ram), cpu(cpu), disk(disk) {}

    bool operator<(Computer& c2) {
        int val1 = ram * 2 + cpu * 3 + disk, val2 = c2.ram * 2 + c2.cpu * 3 + c2.disk;
        if (val1 == val2) {
            return name > c2.name;
        }
        return val1 < val2;
    }
};

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    vector<Computer> computers;
    if (n == 0) {
        return 0;
    }
    for (int i = 0; i < n; i++) {
        string name;
        int r, s, d;
        cin >> name >> r >> s >> d;
        if (n == 1) {
            cout << name << "\n";
            return 0;
        }
        computers.push_back(Computer(name, r, s, d));
    }
    sort(computers.begin(), computers.end());
    cout << computers[computers.size() - 1].name << "\n";
    cout << computers[computers.size() - 2].name << "\n";
}