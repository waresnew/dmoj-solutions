#include <bits/stdc++.h>

using namespace std;
int tasks_diff[10000002];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int number_of_tasks;
    cin >> number_of_tasks;
    for (int i = 0; i < number_of_tasks; i++) {
        int s, f;
        cin >> s;
        cin >> f;
        tasks_diff[s]++;
        tasks_diff[f]--;
    }
    int max_overlap=0;
    for (int i = 1; i <= 10000000;i++) {
        tasks_diff[i] += tasks_diff[i-1];
        max_overlap = max(max_overlap, tasks_diff[i]);
    }
    cout << max_overlap<<"\n";

}