#include <bits/stdc++.h>
#pragma GCC optimize "Ofast"
using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int s,w,l,b,h;
    cin>>s>>w>>l>>b>>h;
    cout << "The area of the square is " << s*s << "\n";
    cout << "The area of the rectangle is " << w*l << "\n";
    cout << "The area of the triangle is " << b*h/2.0 << "\n";
    cout << "The sum of all areas is " << s*s+w*l+b*h/2.0 << "\n";
}