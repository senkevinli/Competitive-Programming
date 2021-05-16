#include <iostream>
#include <algorithm>

/**
 * Nastia and Nearly Good Numbers
 */

using namespace std;

int main() {
    int cases;
    cin >> cases;
    while (cases-- > 0) {
        int a, b;
        cin >> a;
        cin >> b;

        if (b == 1) {
            cout << "NO" << endl;
        } else {
            long long a1, b1;
            cout << "YES" << endl;
            b1 = b;
            a1 = a;

            long long x = a1 * b1;
            long long y = a1;
            long long z = x + y;
            cout << x << " " << y << " " << z << endl;
        }
    }
}
