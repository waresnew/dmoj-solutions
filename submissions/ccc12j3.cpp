#include <bits/stdc++.h>
using namespace std;

int main()
{
    cin.sync_with_stdio(0);
    cin.tie(0);
    int factor;
    cin >> factor;
    char original[3][3] = {{'*', 'x', '*'}, {' ', 'x', 'x'}, {'*', ' ', '*'}};
    for (int i = 0; i < 3; i++)
    {
        for (int f1 = 0; f1 < factor; f1++)
        {
            for (int j = 0; j < 3; j++)
            {
                for (int f2 = 0; f2 < factor; f2++)
                {
                    cout << original[i][j];
                }
            }

            cout << "\n";
        }
    }
}