#include <bits/stdc++.h>

using namespace std;
int seats[100000];
int number_of_seats, number_of_students;

bool check(int &min_dist) { //check if you can fit n students min_dist apart
    int ans = 1;
    int prev = seats[0];
    for (int i = 1; i < number_of_seats; i++) {
        if (seats[i] - prev >= min_dist) {
            prev = seats[i];
            ans++;
        }
    }
    return ans >= number_of_students;
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    cin >> number_of_seats;
    cin >> number_of_students;
    for (int i = 0; i < number_of_seats; i++) {
        cin >> seats[i];
    }
    sort(seats, seats + number_of_seats);
    int low = 1, high = seats[number_of_seats - 1] - seats[0];
    int ans = 1;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (check(mid)) {
            ans = mid;
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    cout << ans << "\n";
}