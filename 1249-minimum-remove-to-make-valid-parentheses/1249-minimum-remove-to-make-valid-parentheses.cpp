class Solution {
public:
    string minRemoveToMakeValid(string s) {
        // First pass: remove extra ')'
        string temp;
        int balance = 0;

        for (char c : s) {
            if (c == '(') {
                balance++;
                temp += c;
            }
            else if (c == ')') {
                if (balance > 0) {
                    balance--;
                    temp += c;
                }
                // Otherwise, skip this ')' because it has no matching '('
            }
            else {
                temp += c;
            }
        }

        // Second pass: remove extra '(' from right to left
        string result;
        
        for (int i = temp.size() - 1; i >= 0; i--) {
            if (temp[i] == '(' && balance > 0) {
                balance--;
                continue;
            }

            result += temp[i];
        }

        reverse(result.begin(), result.end());

        return result;
    }
};
