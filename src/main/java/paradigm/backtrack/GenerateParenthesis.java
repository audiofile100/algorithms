package paradigm.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    private final List<String> res;

    public GenerateParenthesis() {
        res = new ArrayList<>();
    }

    public List<String> generate(int n) {
        res.clear();
        backtrack(0, 0, n, new StringBuilder());
        return res;
    }

    private void backtrack(int L, int R, int n, StringBuilder sb) {
        if (L == n && R == n) {
            res.add(sb.toString());
            return;
        }

        if (L < n) {
            sb.append("(");
            backtrack(L+1, R, n, sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if (R < L) {
            sb.append(")");
            backtrack(L, R+1, n, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {

        GenerateParenthesis gp = new GenerateParenthesis();
        List<String> res = gp.generate(3);

        System.out.println(res);
    }
}
