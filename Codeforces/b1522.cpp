#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

void print_vector (vector<int>& vals) {
    for (auto i : vals) {
        cout << i << " ";
    }
    cout << endl;
}
void solve(vector<int>& vals) {
    int mini = vals[0];
    int idx = 0;
    for (int i = 0; i < vals.size(); ++i) {
        int val = vals[i];
        if (val < mini) {
            mini = val;
            idx = i;
        }
    }

    if (idx != 0) {
        cout << vals.size() << endl;
        int i = 0;
        int j = idx;
        int x = mini;
        int y = mini + idx;
        cout << i + 1 << " " << j + 1 << " " << x << " " << y << endl;
        vals[i] = x;
        vals[j] = y;
        // print_vector(vals);
    } else {
        cout << vals.size() - 1 << endl;
    }

    for (int i = 1; i < vals.size(); ++i) {
        int j = 0;
        int x = mini + i;
        int y = mini;
        cout << i + 1 << " " << j + 1<< " " << x << " " << y << endl;
        vals[i] = x;
        vals[j] = y;
        //print_vector(vals);
    }
}
int main() {
    int cases;
    cin >> cases;
    while (cases-- > 0) {
        int n;
        cin >> n;
        vector<int> vals;
        for (int i = 0; i < n; ++i) {
            int val;
            cin >> val;
            vals.push_back(val);
        }
        solve(vals);

    }
}
