#include <stdio.h>
// 5/8/2023
int main() {
    int n;
    scanf("%d", &n);
    int ans = 0;
    for (int i = 0, x; i < n; ++i) {
        scanf("%d", &x);
        ans^=x;
    }
    printf("%d\n", ans);
}